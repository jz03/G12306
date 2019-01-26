package client;

import service.TicketTimeTask;
import util.Constants;

import java.util.Timer;

/**
 * Java定时任务
 * @author: 冀陆涛
 * @create: 2019-01-17 17:17
 **/
public class TimeTaskClient {
    public static void main(String[] args) {

        Timer timer = new Timer();
        //3秒之后执行定时任务，每隔一分钟执行一次
        timer.schedule(new TicketTimeTask(), Constants.DELAY_TIME,Constants.PERIOD_TIME);
    }
}
