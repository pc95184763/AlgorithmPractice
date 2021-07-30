package Recursion2;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;

    int m = matrix.length ;
    if ( m == 0) {
      return result ;
    }
    int n = matrix[0].length ;

    int up = 0;
    int left = 0;
    int down = m - 1 ;
    int right = n - 1;

    while ( up < down && left < right ) {
      for (int i = left ; i < right ; i++) {
        result.add( matrix[up][i] ) ;
      }
      for (int i = up ; i < down ; i++) {
        result.add( matrix[i][right] ) ;
      }
      for (int i = right ; i > left ; i--) {
        result.add( matrix[down][i] ) ;
      }
      for (int i = down ; i > up ; i--) {
        result.add( matrix[i][left] ) ;
      }

      up++ ;
      left++ ;
      right--;
      down-- ;
    }

    if (up > down || left > right) {
      return result ;
    }
    if (up == down) {
      for (int i = left ; i <= right ; i++) {
        result.add( matrix[up][i] ) ;
      }
    } else {
      for (int i = up ; i <= down ; i++) {
        result.add(matrix[i][left]) ;
      }
    }


    return result ;
  }
}
