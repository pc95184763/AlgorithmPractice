package MyTest;

import java.util.ArrayList;
import java.util.List;

public class SpacePermu {

  public static void main(String[] args) {

    List<String> list = allPermutation("ABC") ;
    for (String s: list) {
      System.out.println( s );
    }
  }


  static List<String> allPermutation( String input) {
      List<String> result = new ArrayList<>() ;
      StringBuilder buf = new  StringBuilder() ;

      DFS( 0, input, buf,result)  ;

      return result ;
  }

  static void DFS( int index , String input ,StringBuilder buf, List<String> result) {
    if ( index == input.length() - 1) {
      buf.append(input.charAt( index) ) ;
      result.add( buf.toString() ) ;
      buf.deleteCharAt( buf.length() - 1 ) ;
      return  ;
    }
    buf.append( input.charAt(index) ) ;
    DFS(index + 1, input, buf, result) ;
    buf.append( " ") ;
    DFS(index + 1, input, buf, result) ;

//    buf.deleteCharAt( buf.length() - 1);
//    buf.deleteCharAt( buf.length() - 1);
  }


}
