/**
 * Java定时任务
 * @author: 冀陆涛
 * @create: 2019-01-17 17:17
 **/
public class TimeTaskClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始查询.....");
        TimerManager timerManager = TimerManager.getInstance();
        timerManager.startTimerTask();
        System.out.println("执行！");

        while(true){
//            timerManager.getTask().isFlag();
//            Thread.sleep(10000);
            System.out.println(timerManager.getTask().isFlag());
//            timerManager.stopTimerTask();
            System.out.println("停止！");
        }
    }
}
