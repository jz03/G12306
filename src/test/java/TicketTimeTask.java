import lombok.Getter;

import java.util.Random;
import java.util.TimerTask;

/**
 * @author: 冀陆涛
 * @create: 2019-01-17 17:19
 **/
@SuppressWarnings("Since15")
public class TicketTimeTask extends TimerTask {
    @Getter
    private boolean flag = false;

    public void run() {
//        Random random = new Random();
//        int i = random.nextInt(100);
        flag = true;
//        if(i%2 == 0){
//
//        }else {
//            flag = false;
//            System.out.println(i +"中华人民万岁！");
//        }
    }


}
