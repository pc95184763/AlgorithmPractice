package MyException;

public class Test5 {
  int count = 0;

  void A() throws Exception {
    try {
      count ++ ;
      try {
        count ++ ;
        try {
          count ++ ;
          throw new Exception() ;
        } catch (Exception e) {
          count ++ ;
          throw new Exception() ;
        }
      } catch (Exception e) {
        count ++ ;
        System.out.println( "count :"+ count);
      }
    } catch (Exception e) {
      count ++ ;
      System.out.println( "来没来");
    }
  }
  void display() {
    System.out.println( count);
  }

  public static void  main(String [] args) throws  Exception {
      Test5 obj = new Test5() ;
      obj.A() ;
      obj.display();
  }

}
