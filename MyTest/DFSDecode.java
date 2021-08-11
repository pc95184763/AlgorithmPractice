package MyTest;
import java.util.*;


public class DFSDecode {

  private  static Map<Integer, Character> map   ;

  public static void main(String[] args) {

    List<String> result = decode("1121") ;

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

    DFS(input, index, buf, result);

    DFS(input, index, buf, result);
  }
//  private char encode(char[] input, int start, int end ) {
//    if( map == null) {
//
//      for (int i = 1; i <= 26 ; i++) {
//
//      }
//    }

//    return map.get() ;
//  }

}



