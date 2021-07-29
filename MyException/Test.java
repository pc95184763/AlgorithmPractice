package MyException;

public class Test {

  static void fun() {
    try {
      throw new NullPointerException() ;

    } catch (NullPointerException e) {
      System.out.println("Caught inside fun().");
      throw e;
    }
  }
  public static void main(String[] args) {

        fun() ;


  }
}
