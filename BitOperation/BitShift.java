package BitOperation;

public class BitShift {

  public static void main(String [] args) {
    int a = 0;
    printBinary(a) ;

    a = 5 ;
    printBinary(a) ;

    a = -5;
    printBinary(a) ;

    a = Integer.MIN_VALUE ;
    printBinary(a) ;

    a = Integer.MAX_VALUE ;
    printBinary(a) ;

    a = -1;
    printBinary(a) ;

    int b = a >> 5;
    printBinary(b) ;

    b = a >>> 5;
    printBinary(b) ;
  }

  public static void printBinary(int value) {
    System.out.println(value + " : ") ;
    StringBuilder builder = new StringBuilder() ;
    for (int shift = 31; shift >= 0; shift--) {
      builder.append( (value >>> shift) & 1) ;
    }
    System.out.println(builder.toString() ) ;
    System.out.println() ;
  }
}
