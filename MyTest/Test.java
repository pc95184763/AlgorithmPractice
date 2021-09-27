package MyTest;

public class Test {

  public static void main(String[] args) {


    System.out.println( decrypt("DGEO", 3) );

  }

  public static String decrypt(String input, int k) {

    k = k % 26 ;
    StringBuilder sb = new StringBuilder() ;
    for (int i = 0 ; i < input.length() ; i ++) {
      if ( input.charAt(i) >= 'A' + k ) {
        sb.append( (char) (input.charAt(i) - k) ) ;
      } else {
        sb.append( (char) (input.charAt(i) + 26 - k) ) ;
      }
    }
    return sb.toString() ;
  }


}

