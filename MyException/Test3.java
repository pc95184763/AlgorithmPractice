package MyException;

public class Test3 {



  public static void main(String[] args) throws TestException {
      try {
        throw new TestException() ;
      }catch (TestException t) {
        System.out.println( "Go to  the Test Exception");
        throw t ;
      } finally {
        System.out.println( "Inside the finally Block");
      }
//    System.out.println("after") ;

  }

}

class TestException extends  Exception {

}

