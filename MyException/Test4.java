package MyException;

public class Test4 {


  public static void main(String[] args) {

    try {
      int a = 0;
      System.out.println("a = " + a) ;
      int b = 20 / a ;
      System.out.println("Division Done") ;
      System.out.println("b = " + b) ;

    } catch (ArithmeticException e) {
      System.out.println("Divide by Zero error") ;
      //抛出则try 之外的语句不会执行，不抛出则outside 的语句会执行
      throw  e ;
    } finally {
      System.out.println("Inside the finally block") ;
    }
    System.out.println("Outside the finally block") ;
  }
}
