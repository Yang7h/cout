
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public  class Active {
    @Test
    public static void second() throws Exception{
        //日期
        int day = Culculation.getTime();

        //文件流
        InputStream fs= new FileInputStream(Sort.adress);
        BufferedInputStream bis = new BufferedInputStream(fs);
        Workbook workbook = new HSSFWorkbook(bis);
        Sheet sheet = workbook.getSheetAt(0);
        //公式格式化
        HSSFFormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        //总销售
        Cell cell = sheet.getRow(21 + (day * 36) - 36 - 1).getCell(1);
        CellValue evaluate = formulaEvaluator.evaluate(cell);
        double sell = 0;
        try {
            sell = Double.parseDouble(evaluate.formatAsString());
        } catch (Exception e) {
            System.out.println("总销售:0");
        }
        System.out.println("总销售:"+sell/10);

        //素金
        Cell cellSj = sheet.getRow(4 + (day * 36) - 36 - 1).getCell(204);
        CellValue evaluateSJ = formulaEvaluator.evaluate(cellSj);
        double sellSj = 0;
        try {
            sellSj = Double.parseDouble(evaluateSJ.formatAsString());
        } catch (Exception e) {
            System.out.println("素金：0");
        }
        System.out.println("素金："+sellSj/10);

        //非素
        Cell cellFs = sheet.getRow(4 + (day * 36) - 36 - 1).getCell(205);
        CellValue evaluateFs = formulaEvaluator.evaluate(cellFs);
        double sellFs = 0;
        try {
            sellFs = Double.parseDouble(evaluateFs.formatAsString());
        } catch (Exception e) {
            System.out.println("非素：0");
        }
        System.out.println("非素："+sellFs/10);

        //黄金
        StringBuffer hj = two(sheet, day, Sort.QIANZU, Sort.MENGJINYUAN);
        hj.insert(0,"HJ:");
        System.out.println(hj);
        //玲珑小饰
        StringBuffer ll = one(sheet, day, Sort.LINGLONG);
        ll.insert(0,"LL:");
        System.out.println(ll);
        //钻石
        StringBuffer zs = one(sheet, day, Sort.ZUANSHI);
        zs.insert(0,"ZS:");
        System.out.println(zs);
        //k金
        StringBuffer kj = one(sheet, day, Sort.KJIN);
        kj.insert(0,"KJ:");
        System.out.println(kj);
        //翡翠
        StringBuffer fc = one(sheet, day, Sort.FEICUI);
        fc.insert(0,"FC:");
        System.out.println(fc);
        //硬金
        StringBuffer yj = one(sheet, day, Sort.YingJ);
        yj.insert(0,"YingJ:");
        System.out.println(yj);
        //银饰
        StringBuffer ys = one(sheet, day, Sort.YinSHi);
        ys.insert(0,"YS:");
        System.out.println(ys);
        //名表
        StringBuffer mb = one(sheet, day, Sort.MINGBIAO);
        mb.insert(0,"MB:");
        System.out.println(mb);
        //珍珠
        StringBuffer zz = one(sheet, day, Sort.ZHENZHU);
        zz.insert(0,"ZZ:");
        System.out.println(zz);
        //镶嵌 黄宝
        StringBuffer jxb = one(sheet, day, Sort.XIANGQIAN);
        jxb.insert(0,"JXB:");
        System.out.println(jxb);
        //编织
        StringBuffer bz = one(sheet, day, Sort.BIANZHI);
        bz.insert(0,"BZ:");
        System.out.println(bz);
        bis.close();
    }
// num + (day*36) - 36 -1
    public static StringBuffer two (Sheet sheet,int day,int num1,int num2){
        int i = 0;
        double sum =0.00;
        for (Cell cell : sheet.getRow((num1+(day*36)-36)-1)) {
            if (cell.getCellType() == 0) {
                sum +=  cell.getNumericCellValue();
                i++;
            }
        }
        for (Cell cell : sheet.getRow((num2+(day*36)-36)-1)) {
            if (cell.getCellType() == 0) {
                sum +=  cell.getNumericCellValue();
                i++;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(i);
        sb.append('件');
        sb.append(sum/10);
        return sb;
    }
    public static StringBuffer one (Sheet sheet,int day,int num1){
        int i = 0;
        double sum =0.00;
        for (Cell cell : sheet.getRow((num1+(day*36)-36)-1)) {
            if (cell.getCellType() == 0) {
                sum +=  cell.getNumericCellValue();
                i++;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(i);
        sb.append('件');
        sb.append(sum/10);
        return sb;
    }

}