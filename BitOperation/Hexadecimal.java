package BitOperation;

public class Hexadecimal {

  public static void main (String[] args) {
    int num = 255 ;
   // System.out.println(hex1(num)) ;
    //System.out.println(  (int)('A') ) ;
  }


  public static String hex (int num) {
    if ( num == 0 ) {
      return  "0x0";
    }
    char [] base = { '0', '1', '2', '3','4','5','6','7','8','9','A','B','C','D','E','F' } ;
    StringBuilder result  = new StringBuilder() ;
    result.append("0x") ;
    boolean isLeading = true ;

    for (int fourdits = 28 ; fourdits >= 0 ; fourdits -= 4 ) {
      char remainder = base [ ( num >> fourdits ) & 0xF ] ;
      if ( remainder != '0' || !isLeading) {
        result.append (remainder ) ;
        isLeading = false;
      }

    }
    return result.toString() ;
  }
  public static String hex1(int num) {
    String prefix = "0x" ;
    if ( num == 0 ) {
      return prefix + "0";
    }

    StringBuilder solution = new StringBuilder() ;
    while ( num > 0 ) {
      int remainder = num % 16;
      if (remainder < 10) {

        solution.append('0' + remainder) ;
      }
      else {
        solution.append( remainder - 10 + 'A') ;
      }
      num >>>= 4 ;
    }
    return prefix + solution.reverse().toString() ;
  }
}
