package MyException;

public class Test1 {

  static void fun() throws IllegalAccessException {
    try {
      System.out.println("Inside fun(). ") ;
      throw new IllegalAccessException() ;
    }
    finally {
      System.out.println("hello World") ;
    }

  }

  public static void main(String[] args) throws IllegalAccessException {

      fun() ;

  }
}
