import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class First {
    public static void main(String arg[]){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String sDate = sdf.format(date);
        StringBuffer first = new StringBuffer();
        first.append(sDate);

        first.append("\n");
        first.append("提报人：");
        System.out.println("提报人：");
        String name = scanString();
        first.append(name);

        first.append("\n");
        first.append("LMZB总任务：");
        System.out.println("LMZB任务：");
        Double rw = scanDouble();
        first.append(rw);

        first.append("\n");

        System.out.println(first);
    }
    public static Double scanDouble(){
        double answer1 = 0.0;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            answer1 = scan.nextInt();
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        scan.close();
        return answer1;
    }
    public static String scanString(){
        String answer = null;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            answer = scan.nextLine();
        }
         scan.close();
        return answer;
    }
}
