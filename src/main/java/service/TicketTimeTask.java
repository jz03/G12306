package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.TrainTimes;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import util.Constants;
import util.SendEmail;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * @author: 冀陆涛
 * @create: 2019-01-17 17:19
 **/
@SuppressWarnings("Since15")
public class TicketTimeTask extends TimerTask {
    /*日志监控*/
    private static final Logger logger = Logger.getLogger(TicketTimeTask.class);

    public void run() {
        String url = Constants.URL;
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        String time = format.format(dateNow);
        logger.info(Constants.START_LOG);
        try{
            String result = getReq(url);
            logger.info(result);
            List<String> ticList = filterMsg(result);
            //如果查询到了信息，发送出去
            if(ticList.size()!=0){
                logger.info("共"+ticList.size()+"趟.");
                writeExcel(ticList, time);
            }
        }catch (Exception e){
            logger.info(Constants.EXCEPTION_LOG);
        }
        logger.info(Constants.END_LOG);
    }

    /**
     * 写入Excel文件
     * 有票则发送email
     *
     * @param ticList
     * @param time
     */
    private void writeExcel(List<String> ticList, String time) throws Exception{
        logger.info("开始写入Excel文件...");
        Workbook  workbook = Workbook.getWorkbook(new File(Constants.FILE_PATH));

        //创建一个副本
        WritableWorkbook writeWorkbook = Workbook.createWorkbook(new File(Constants.FILE_PATH),workbook);
        WritableSheet sheet = writeWorkbook.getSheet(0);
        //行
        int row = sheet.getRows();
        Label lable = new Label(1, row, time);
        sheet.addCell(lable);
        StringBuilder sb = new StringBuilder();
        for(String str : ticList){
            String[] strs = str.split(Constants.SPLITS);
            sb.append(TrainTimes.valueOf(strs[0])+Constants.SPACE_1+ Constants.SEAT_LOG +strs[1]+Constants.BR_SYMBOL);
            int col = TrainTimes.valueOf(strs[0]).ordinal() + 2;
            Label con = new Label(col, row, strs[1]);
            sheet.addCell(con);
        }
        writeWorkbook.write();
        writeWorkbook.close();
        logger.info("excel写入成功！");
        logger.info("开始发送电子邮件...");
        //发送邮件
        SendEmail sendEmail = new SendEmail();
        sendEmail.send(Constants.SUBJECT, sb.toString());
        logger.info("电子邮件发送成功！");

    }

    /**
     * 二等座有座的车次
     * @param input
     * @return
     */
    private static List<String> filterMsg(String input){
        logger.info("开始过滤json数据...");
        List<String> resList = new ArrayList<String>();
        JSONObject object = JSON.parseObject(input);
        JSONObject data = object.getJSONObject("data");
        JSONArray result = data.getJSONArray("result");
        for (Object res : result) {
            String re = (String) res;
            String[] strs = re.split(Constants.SPLITS);
            //为空时不可预定
            String ticket = strs[0];
            //二等座
            String secondSeat = strs[30];
            //出发时间
            String startTime = strs[8];
            //到达时间
            String endTime = strs[9];
            if (!ticket.isEmpty() && !secondSeat.equals(Constants.NOTHING) && !secondSeat.isEmpty() && checkTime(startTime,endTime)) {
//                String tic =  "车次:"+strs[3]+" 出发时间:"+startTime+" 到达时间:"+endTime+" 历时:"+strs[10]+" 二等座余票: "+secondSeat;
                String tic =strs[3] + Constants.SPLIT + secondSeat;
                resList.add(tic);
            }
        }
        logger.info("json数据过滤成功");
        return resList;
    }

    /**
     *  get请求
     * @param url
     * @return
     */
    private static String getReq(String url){
        logger.info("开始请求网址...");
        String result = Constants.SPACE_0;
        // 创建客户端
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //创建一个get请求
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //发送请求并获取返回结果
            response = httpclient.execute(httpget);

            if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){//判断状态码
                HttpEntity httpEntity = response.getEntity(); //获取返回body
                result = EntityUtils.toString(httpEntity,Constants.CHARSET);// 转成string
            }

        } catch(IOException e){

        }finally {
            try{
                if(response != null){
                    response.close(); //释放连接
                }
            }catch(Exception e){}
            try{
                if(httpclient != null){
                    httpclient.close();//关闭客户端
                }
            }catch(Exception e){}
        }
        logger.info("网址请求成功！");
        return result;
    }

    /**
     * 出发时间和到达时间进行检查
     *
     * @param startTime 出发时间
     * @param endTime 到达时间
     * @return true：符合要求；false：不符合要求
     */
    private static boolean checkTime(String startTime, String endTime){
        boolean result = false;
        if(startTime.compareTo(Constants.START_TIME)>=0 && startTime.compareTo(Constants.END_TIME)<0
            && endTime.compareTo(Constants.START_TIME)>=0 && endTime.compareTo(Constants.END_TIME_1)<0){
            result = true;
        }
        return result;
    }
}
