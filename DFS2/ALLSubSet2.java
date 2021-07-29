package DFS2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ALLSubSet2 {

  public static void main(String[] args) {
      List<String> list = subSets("") ;
      for ( String s: list) {
        System.out.println(s) ;
      }
  }


  public static List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>() ;
    StringBuilder buf = new StringBuilder() ;
    char[] arr = set.toCharArray() ;
    Arrays.sort(arr) ;

    DFS(0, buf, arr , result) ;

    return result;
  }

  private static void DFS(int index , StringBuilder buf, char[] arr,List<String> result) {


    if (index == arr.length )  {
      result.add( buf.toString() ) ;
      return ;
    }
    buf.append(arr[index]) ;
    DFS(index + 1, buf, arr, result) ;
    buf.deleteCharAt(buf.length() - 1) ;

    while (index + 1 < arr.length && arr[index + 1] == arr[index] ) {
      index++ ;
    }
    DFS(index + 1, buf, arr, result) ;
  }
}
