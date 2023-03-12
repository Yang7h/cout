import javax.swing.*;
import java.io.File;

class Sort {
 static final int QIANZU = 4;
 static final int MENGJINYUAN = 7;
 static final int LINGLONG = 8 ;
 static final int ZUANSHI = 9;
 static final int KJIN = 10;
 static final int FEICUI = 11;
 static final int YingJ = 12;
  static final int YinSHi = 16;
  static final int MINGBIAO = 18;
  static final int ZHENZHU = 13;
  static final int XIANGQIAN = 17;
  static final int BIANZHI = 19;
 static  String adress =null;
  static void setFile(){
   JFileChooser chooser = new JFileChooser();

   chooser.showOpenDialog(null);
   File file = chooser.getSelectedFile();
    adress = file.toString();

  }
 }
