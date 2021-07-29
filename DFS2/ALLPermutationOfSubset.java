package DFS2;

import java.util.ArrayList;
import java.util.List;

public class ALLPermutationOfSubset {

  public static void main(String[] args) {
    List<String> list = allPermutationsOfSubsets("abc") ;

    for (String s : list) {
      System.out.println( s);
    }
  }

  public static List<String> allPermutationsOfSubsets(String set) {
    // Write your solution here
    List<String> result = new ArrayList<>() ;

    if (set == null) {
      return result ;
    }
    char[] arr = set.toCharArray() ;

    DFS(0, arr , result) ;

    return result ;
  }
  static void DFS  (int index, char[] arr, List<String> result ) {

    result.add( new String(arr,0, index)  ) ;
    if (index == arr.length ) {
      return ;
    }
    for (int i = index; i < arr.length ; i ++) {
      swap(arr, i, index);
      DFS(index + 1, arr, result);
      swap(arr, i, index);
    }

  }

  static void swap(char[] arr, int i, int j) {
      char temp = arr[i] ;
      arr[i] = arr[j] ;
      arr[j] = temp ;
  }
}
