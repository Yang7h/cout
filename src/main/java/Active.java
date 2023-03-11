
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
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String format = sdf.format(date);
        int day =Integer.parseInt(format);

        //文件流
        InputStream fs= new FileInputStream("C:\\Users\\admin\\Desktop\\2023年3月份每日销售统计表.xls");
        BufferedInputStream bis = new BufferedInputStream(fs);
        Workbook workbook = new HSSFWorkbook(bis);
        Sheet sheet = workbook.getSheetAt(0);

        //公式格式化
        HSSFFormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        //总销售
        Cell cell = sheet.getRow(21 + (3 * 36) - 36 - 1).getCell(1);
        CellValue evaluate = formulaEvaluator.evaluate(cell);
        double sell = Double.parseDouble(evaluate.formatAsString());
        System.out.println("总销售:"+sell/10);

        //素金
        Cell cellSj = sheet.getRow(4 + (3 * 36) - 36 - 1).getCell(204);
        CellValue evaluateSJ = formulaEvaluator.evaluate(cellSj);
        double sellSj = Double.parseDouble(evaluateSJ.formatAsString());
        System.out.println("素金："+sellSj/10);

        //非素
        Cell cellFs = sheet.getRow(4 + (3 * 36) - 36 - 1).getCell(205);
        CellValue evaluateFs = formulaEvaluator.evaluate(cellFs);
        double sellFs = Double.parseDouble(evaluateFs.formatAsString());
        System.out.println("非素："+sellFs/10);

        //非素比
        Cell cellFsb = sheet.getRow(4 + (3 * 36) - 36 - 1).getCell(206);
        CellValue evaluateFsb = formulaEvaluator.evaluate(cellFsb);
        double sellFsb = Double.parseDouble(evaluateFsb.formatAsString());
        System.out.println("非素比："+String.format("%.2f", sellFsb*100)+"%");

        //黄金
        StringBuffer hj = two(sheet, 3, Sort.QIANZU, Sort.MENGJINYUAN);
        hj.insert(0,"HJ:");
        System.out.println(hj);
        //玲珑小饰
        StringBuffer ll = one(sheet, 3, Sort.LINGLONG);
        ll.insert(0,"LL:");
        System.out.println(ll);
        //钻石
        StringBuffer zs = one(sheet, 3, Sort.ZUANSHI);
        zs.insert(0,"ZS:");
        System.out.println(zs);
        //k金
        StringBuffer kj = one(sheet, 3, Sort.KJIN);
        kj.insert(0,"KJ:");
        System.out.println(kj);
        //翡翠
        StringBuffer fc = one(sheet, 3, Sort.FEICUI);
        fc.insert(0,"FC:");
        System.out.println(fc);
        //硬金
        StringBuffer yj = one(sheet, 3, Sort.YingJ);
        yj.insert(0,"YingJ:");
        System.out.println(yj);
        //银饰
        StringBuffer ys = one(sheet, 3, Sort.YinSHi);
        ys.insert(0,"YS:");
        System.out.println(ys);
        //名表
        StringBuffer mb = one(sheet, 3, Sort.MINGBIAO);
        mb.insert(0,"MB:");
        System.out.println(mb);
        //珍珠
        StringBuffer zz = one(sheet, 3, Sort.ZHENZHU);
        zz.insert(0,"ZZ:");
        System.out.println(zz);
        //镶嵌 黄宝
        StringBuffer jxb = one(sheet, 3, Sort.XIANGQIAN);
        jxb.insert(0,"JXB:");
        System.out.println(jxb);
        //编织
        StringBuffer bz = one(sheet, 3, Sort.BIANZHI);
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
    @Test
    public void first(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String sDate = sdf.format(date);
        StringBuffer first = new StringBuffer();
        first.append(sDate);
        first.append("\n");
        first.append("提报人：");
        first.append("\n");
        first.append("LMZB总任务：");
        System.out.println("LMZB任务：");
        double rw = 0.0;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            rw = scan.nextInt();
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        first.append(rw);
        System.out.println(first);
    }
}