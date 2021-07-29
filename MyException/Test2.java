package MyException;

public class Test2 {


  static void fun() throws IllegalAccessException, ClassNotFoundException {
      System.out.println("Inside fun(). ") ;
      throw new IllegalAccessException() ;
  }

  public static void main(String[] args)  {

    try {
      fun() ;
    } catch (IllegalAccessException | ClassNotFoundException e) {
      e.printStackTrace();
    }


  }
}
