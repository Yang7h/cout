
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Culculation {
    public static void main (String[] arg) {
        Sort.setFile();
        First.first();
        try {
            Active.second();
        } catch (Exception e) {
            System.out.println("检查输入内容");
        }

        try {
            Third.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String format = sdf.format(date);
        int day =Integer.parseInt(format);
        return day;
    }
}
