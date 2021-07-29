package Practice19Test;

public class OuterClassTest {
  public static void main(String[] args) {

  }



}


class OuterClass {
  private static String msg1 = "Static Message" ;
  private String msg2 = "Non-Static Message" ;

  public static class NestedStaticClass {


    public void printMessage () {
      System.out.println(msg1);
    }
    public static void display() {}

  }
  // 特性里 不能定义 共性
  //
  public class InnerClass {


    public void display() {
      System.out.println(msg1);
    }



  }


}