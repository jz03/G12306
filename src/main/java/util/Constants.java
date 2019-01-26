package util;

/**
 * 定数
 *
 * @author: 冀陆涛
 * @create: 2019-01-25 15:21
 **/
public final class Constants {
    /*延时：3秒*/
    public static int DELAY_TIME = 3000;
    /*程序间隔时间：1分钟*/
    public static int PERIOD_TIME = 60000;
    /*发车日期*/
    public static String DATE = "2019-02-22";
    /*12306请求url*/
    public static String URL = "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date="+DATE+"&leftTicketDTO.from_station=ZZF&leftTicketDTO.to_station=SHH&purpose_codes=ADULT";
    /*日期格式*/
    public static String DATE_FORMAT = "yyyy年MM月dd日 hh:mm:ss";
    /*编码格式*/
    public static String CHARSET = "UTF-8";
    /*程序开始log*/
    public static String START_LOG = "开始查询.....";
    /*程序结束log*/
    public static String END_LOG = "--------------------------------";
    /*空字符串*/
    public static String SPACE_0 = "";
    /*一个字符串空格*/
    public static String SPACE_1 = " ";
    /*当前时间log*/
    public static String CURRENT_TIME_LOG = "## 当前查询时间：";
    /*捕获异常*/
    public static String EXCEPTION_LOG = "此次查询出现异常！";
    /*记录文件的路径*/
    public static String FILE_PATH = "E:\\new\\test.xls";
    /*email内容的换行符*/
    public static String BR_SYMBOL = "<br>";
    /*座位*/
    public static String SEAT_LOG = "座位：";
    /*邮件主题*/
    public static String SUBJECT = "有火车票了";
    /*转义过的分隔符*/
    public static String SPLITS = "\\|";
    /*未转义的分隔符*/
    public static String SPLIT = "|";
    /*无*/
    public static String NOTHING = "无";
    /*发车时间*/
    public static String START_TIME = "12:00";
    /*到达时间*/
    public static String END_TIME = "22:00";
    /*到达时间1*/
    public static String END_TIME_1 = "22:30";
    /*车次log*/
    public static String TRAIN_TIMES_LOG = "车次：";
    /*出发时间log*/
    public static String FROM_DATE_LOG = "出发时间：";
    /*到达时间log*/
    public static String TO_DATE_LOG = "到达时间：";
    /*历时log*/
    public static String FROM_TO_DATE_LOG = "历时：";
}
