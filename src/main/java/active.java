
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public  class active {
    @Test
    public void second() throws Exception{
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String format = sdf.format(date);
        int day =Integer.parseInt(format);
        InputStream fs= new FileInputStream("C:\\Users\\正经的电脑\\Desktop\\2023年3月份每日销售统计表.xls");
        BufferedInputStream bis = new BufferedInputStream(fs);
        Workbook workbook = new HSSFWorkbook(bis);
        Sheet sheet = workbook.getSheetAt(0);
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
        fs.close();
    }
// num + (day*36) - 36 -1
    public StringBuffer two (Sheet sheet,int day,int num1,int num2){
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
    public StringBuffer one (Sheet sheet,int day,int num1){
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