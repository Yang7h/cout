import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Third {

    public static void last () throws  Exception{
        //日期
        int day = Culculation.getTime();

        //非素比
        double sellFs = request(4, day, 206);
        System.out.println("非素比："+String.format("%.2f", sellFs*100)+"%");

        //进店
        StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("进店：");
        stringBuffer.append("进店：");
        int jd = scanner.nextInt();
        stringBuffer.append(jd);
        stringBuffer.append("批");
        stringBuffer.append(scanner.nextInt());
        stringBuffer.append("人");

        //成交
        stringBuffer.append("\n");
        System.out.println("成交：");
        stringBuffer.append("成交：");
        int cj = scanner.nextInt();
        stringBuffer.append(cj);
        stringBuffer.append("单");

        //成交率
        stringBuffer.append("\n");
        double cjv = 0.0;
        try {
             cjv = cj/jd;
        } catch (Exception e) {
            cjv = 1.0;
        }
        stringBuffer.append("成交率：");
        stringBuffer.append(cjv*100+"%");
        System.out.println(stringBuffer);

        //总销售累计
        System.out.println("总销售累计:"+request2(1,2)/10);

        //素金累计
        System.out.println("素金累计:"+request2(1,3)/10);

        //非素累计
        System.out.println("素金累计:"+request2(1,4)/10);

        //总完成率
        rate(0,1,5,"总完成率");

        //素金完成率
        rate(0,1,6,"素金完成率");

        //非素完成率
        rate(0,1,7,"非素完成率");

        //总非素比
        rate(0,1,8,"总非素比");
        System.out.println("总积分完成率： 0%");
        System.out.println("汇报完毕!");
    }
    static void rate(double num,int row,int cell,String content){
        try {
            num = request2(row,cell);
            System.out.println(content+":"+String.format("%.2f", num*100)+"%");
        } catch (Exception e) {
            System.out.println(content+":"+String.format("%.2f", num*100)+"%");
        }
    }
    static double request(int row, int day, int cell) throws Exception{
        //文件流
        InputStream fs= new FileInputStream(Sort.adress);
        BufferedInputStream bis = new BufferedInputStream(fs);
        Workbook workbook = new HSSFWorkbook(bis);
        Sheet sheet = workbook.getSheetAt(0);

        //公式格式化
        HSSFFormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        Cell cell1 = sheet.getRow(row + (day * 36) - 36 - 1).getCell(cell);
        CellValue evaluateFsb = formulaEvaluator.evaluate(cell1);
        double sell = 0;
        try {
            sell = Double.parseDouble(evaluateFsb.formatAsString());
        } catch (Exception e) {
            return sell;
        }
        bis.close();
        return sell;
    }

    static double request2(int row, int cell) throws Exception{
        //文件流
        InputStream fs= new FileInputStream(Sort.adress);
        BufferedInputStream bis = new BufferedInputStream(fs);
        Workbook workbook = new HSSFWorkbook(bis);
        Sheet sheet = workbook.getSheetAt(0);

        //公式格式化
        HSSFFormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        Cell cell2 = sheet.getRow(row).getCell(cell);
        CellValue evaluate = formulaEvaluator.evaluate(cell2);
        double sell = 0;
        try {
            sell = Double.parseDouble(evaluate.formatAsString());
        } catch (Exception e) {
            return sell;
        }
        bis.close();
        return sell;
    }
}
