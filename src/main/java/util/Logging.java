package util;

import java.util.Date;

public class Logging {
  public static void out(Date date) {
    String h = String.valueOf(date.getHours());
    String m = String.valueOf(date.getMinutes());
    String s = String.valueOf(date.getSeconds());
    System.out.println(h + ":" + m + ":" + s);
  }
}
