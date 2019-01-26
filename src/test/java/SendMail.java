import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 发送email
 *
 * @author: 冀陆涛
 * @create: 2019-01-23 15:17
 **/
public class SendMail {
    public static String serviceAcc = "ji_lutao@163.com";
    public static String servicePwd = "jlt461700";
    public static String serviceHost = "smtp.163.com";
    public static String recAcc = "J_lutao@163.com";

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.host", serviceHost);
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties);
        session.setDebug(false);
        MimeMessage msg = creatMsg(session,serviceAcc,recAcc);

        Transport transport = session.getTransport();
        transport.connect(serviceAcc,servicePwd);
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
    }

    /**
     *  创建发送信息
     *
     * @param session
     * @param serviceAcc 发送邮箱
     * @param recAcc 接收邮箱
     * @return
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    private static MimeMessage creatMsg(Session session, String serviceAcc, String recAcc) throws UnsupportedEncodingException, MessagingException {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(serviceAcc,"冀州","UTF-8"));
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recAcc,"007","UTF-8"));
        msg.setSubject("年终奖通知","UTF-8");
        msg.setContent("今年的年终奖为4000元。请留意。","text/html;charset=UTF-8");
        msg.setSentDate(new Date());
        msg.saveChanges();
        return msg;
    }
}
