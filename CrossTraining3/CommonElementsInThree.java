package CrossTraining3;


//Input: new int[]{1,1,3,4,4,7}, new int[]{1,1,3,3,4,4,4}, new int[]{1,1,1,3,4,4,5}
//expected:<[1, 1, 3, 4, 4]> but was:<[0, 1, 2]>

import java.util.*;

public class CommonElementsInThree {

  public static void main(String[] args) {
      int[] a = {1,2,3,3} ;
      int[] b = {2,3,4,4,5} ;
      int[] c = {1,1,3,3} ;

      List<Integer> result = common(a,b,c) ;
      for (Integer i : result) {
          System.out.print(i + " ") ;
      }
  }

  public static List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here
    int indexA = 0 ;
    int indexB = 0 ;
    int indexC = 0 ;

    List<Integer> result = new ArrayList<>() ;

    while ( indexA < a.length && indexB < b.length && indexC < c.length) {
      if ( a[indexA] == b[indexB] && a[indexA] == c[indexC] ) {
        result.add(a[indexA] ) ;
        indexA++ ;
        indexB++ ;
        indexC++ ;

      } else if ( a[indexA] < b[indexB] && a[indexA] < c[indexC]) {
        indexA++ ;
      } else if ( b[indexB] < a[indexA] && b[indexB] < c[indexC]) {
        indexB++ ;
      } else {
        indexC++ ;
      }
    }
    return result ;
  }
}
