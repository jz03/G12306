package client;

import util.SendEmail;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author: 冀陆涛
 * @create: 2019-01-09 16:47
 **/
@SuppressWarnings("Since15")
public class MyTest {
    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        SendEmail sendEmail = new SendEmail();
        sendEmail.send("抢票通知","共有三趟火车可以抢！");
    }
}

