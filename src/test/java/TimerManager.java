import lombok.Getter;

import java.util.Timer;

/**
 * @author: 冀陆涛
 * @create: 2019-01-18 15:29
 **/
public class TimerManager {
    private static TimerManager timerManager = null;
    @Getter
    private TicketTimeTask task = null;

    private Timer timer = new Timer();
    public static TimerManager getInstance(){
        if(timerManager == null ){
            timerManager = new TimerManager();
        }
        return timerManager;
    }

    public void startTimerTask(){
        timer.purge();
        if(task == null){
            task = new TicketTimeTask();
        }
        timer.schedule(task,3000,5000);
    }

    public void stopTimerTask(){
        timer.cancel();
        task = null;
    }
}
