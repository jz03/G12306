package util;

import lombok.Setter;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 发送Email
 *
 * @author: 冀陆涛
 * @create: 2019-01-23 16:22
 **/
public class SendEmail {

    public String serviceAcc = "ji_lutao@163.com";
    public String servicePwd = "jlt461700";
    public String serviceHost = "smtp.163.com";
    @Setter
    public String recAcc = "J_lutao@163.com";

    /**
     * 发送邮件
     *
     * @param subject 发送主题
     * @param content 发送内容
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void send(String subject,String content) throws MessagingException, UnsupportedEncodingException {
        /*设置发送属性*/
        Properties properties = new Properties();
        // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.host", serviceHost);
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties);
        session.setDebug(false);

        /*设置发送信息*/
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(serviceAcc,"冀州","UTF-8"));
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recAcc,"007","UTF-8"));
        msg.setSubject(subject,"UTF-8");
        msg.setContent(content,"text/html;charset=UTF-8");
        msg.setSentDate(new Date());
        msg.saveChanges();

        /*发送*/
        Transport transport = session.getTransport();
        transport.connect(serviceAcc,servicePwd);
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
    }

}
