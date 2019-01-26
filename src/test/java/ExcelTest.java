import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author: 冀陆涛
 * @create: 2019-01-22 16:22
 **/
public class ExcelTest {
    public static void main(String[] args) throws IOException, BiffException, WriteException {
        Workbook workbook = Workbook.getWorkbook(new File("E:\\new\\test.xls"));
        //创建一个副本
        WritableWorkbook writeWorkbook = Workbook.createWorkbook(new File("E:\\new\\test.xls"),workbook);
        WritableSheet sheet = writeWorkbook.getSheet(0);
        //列
//        int col = sheet.getColumns();
        //行
        int row = sheet.getRows();
        Label lable = new Label(1, row, new Date().toString());
        sheet.addCell(lable);
//        System.out.println(col+" "+row);
        writeWorkbook.write();
        writeWorkbook.close();
    }
}
