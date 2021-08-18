package MyTest;
import java.util.*;

// find all decode ways
// DFS to solve this problem, each level consider two possiable ways, either decode 1 letter or 2 letters
//
//                                 1121
//                                /   \
//                              A121   K21
//

public class DFSDecode {


  public static void main(String[] args) {
    List<String> result = decode("1131") ;
    for (String s: result) {
      System.out.println( s );
    }
  }


  public static List<String> decode(String input) {
    List<String> result = new ArrayList<>() ;

    char[] array = input.toCharArray() ;

    StringBuilder buf = new StringBuilder() ;

    DFS(array, 0 , buf ,result) ;

    return result ;
  }

  private static void DFS (char[] input, int index, StringBuilder buf, List<String> result) {
    if (index >= input.length ) {
      result.add( buf.toString() ) ;
      return ;
    }
    if (input[index] != '0' ) {

      buf.append( encode(input, index,   1)  ) ;
      DFS(input, index + 1, buf, result);
      buf.deleteCharAt(buf.length() - 1) ;
    }

    if ( input[index] != '0'  &&  index + 1 < input.length  && Integer.valueOf( new String(input, index,  2) ) <= 26  ) {
      buf.append( encode(input, index,   2)  ) ;
      DFS(input, index + 2, buf, result);
      buf.deleteCharAt(buf.length() - 1) ;
    }

  }

  private static char encode(char[] input, int start, int length ) {
    int value  = Integer.valueOf( new String(input, start,  length ) );
    return (char) ('A' + value - 1);
  }

}



