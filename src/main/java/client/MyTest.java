package client;

import org.apache.log4j.Logger;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author: 冀陆涛
 * @create: 2019-01-09 16:47
 **/
@SuppressWarnings("Since15")
public class MyTest {
    private static final Logger logger = Logger.getLogger(MyTest.class);
    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
        System.out.println(System.getProperty("user.dir").replace("\\","/")+"/logs/debug.log");
        String rootPath = System.getProperty("user.dir").replace("\\","/");
        System.setProperty("log.base",rootPath);
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}

