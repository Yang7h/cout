
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;


public class Culculation {
    public static void main (String[] arg) {
        First.first();
        try {
           // Active.second();
        } catch (Exception e) {
            System.out.println("检查输入内容");
        }
    }
}
