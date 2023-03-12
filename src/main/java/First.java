import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class First {
    public static void first(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String sDate = sdf.format(date);
        StringBuffer first = new StringBuffer();
        first.append(sDate);
        Scanner sc = new Scanner(System.in);
        first.append("\n");
        first.append("提报人：");
        System.out.println("提报人：");
        String name = sc.nextLine();
        first.append(name);

        try {
            double zrw = Third.request2(1, 9);
            System.out.println("LMZB任务:"+zrw);

            double sjrw = Third.request2(1, 10);
            System.out.println("素金任务:"+sjrw);

            double fsrw = Third.request2(1, 11);
            System.out.println("非素任务:"+fsrw);
        } catch (Exception e) {
            e.printStackTrace();
        }


        first.append("\n");
        first.append("今日目标：");
        System.out.println("今日目标：");
        int jrmb = sc.nextInt();
        first.append(jrmb);

        first.append("\n");
        first.append("素金目标：");
        System.out.println("素金目标：");
        int sjmb = sc.nextInt();
        first.append(sjmb);

        first.append("\n");
        first.append("非素目标：");
        System.out.println("非素目标：");
        int fsmb = sc.nextInt();
        first.append(fsmb);
        System.out.println(first);
    }

}
