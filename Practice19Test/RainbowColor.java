package Practice19Test;

public class RainbowColor {
  public static final int RED = 0;
  public static final int ORANGE = 1;
  public static final int YELLOW = 2;
  public static final int GREEN = 3;
  public static final int CYAN = 4;
  public static final int BLUE = 5;
  public static final int PURPLE = 6;

  public static void main(String [] args) {
    for (RainbowColorTest rc: RainbowColorTest.values()) {
      System.out.println(rc) ;
    }
  }
}

enum RainbowColorTest {
  RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE


}


enum WeekDayEnum {
  Mon, Tue, Wed, Thu, Fri, Sat, Sun
}


