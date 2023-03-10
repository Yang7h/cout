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

        first.append("\n");
        first.append("LMZB总任务：");
        System.out.println("LMZB任务：");
        int rw = sc.nextInt();
        first.append(rw);

        first.append("\n");
        first.append("素金任务：");
        System.out.println("素金任务：");
        int sj = sc.nextInt();
        first.append(sj);

        first.append("\n");
        first.append("非素任务：");
        System.out.println("非素任务：");
        int fs = sc.nextInt();
        first.append(fs);

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
