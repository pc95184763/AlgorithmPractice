package DP3;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LargestSubMatrixSum {

  public static void main(String [] args) {
    int[][] arr = new int[][] { {-1} } ;
    System.out.println( largest(arr) );
  }

  public static int largest(int[][] matrix) {
    // Write your solution here
    int ROWS = matrix.length ;
    int COLS = matrix[0].length ;

    //used to store the prefix sum in column-wise O(n ^ 2)
    int[][] columnPrefix = columnPrefix(matrix, ROWS, COLS )  ;

    //used to buffer the prefix sum in one line
    int [] temp = new int[COLS] ;
    int globalMax = Integer.MIN_VALUE;
    for ( int top = 0 ; top < matrix.length ; top++) {
      for (int bottom = top ; bottom < matrix.length ; bottom++) {

        for ( int k = 0 ; k < COLS ; k++) {
          temp[k] = columnPrefix[bottom][k] - columnPrefix[top][k] + matrix[top][k] ;
        }
        globalMax = Math.max(globalMax, largestSubarraySum(temp) ) ;
      }
    }
    return globalMax ;
  }
  private static int[][] columnPrefix (int[][] matrix, int ROWS, int COLS) {
    int[][] result = new int[ROWS][COLS] ;
    for (int j = 0 ; j < COLS ; j++) {
      for (int i = 0 ; i < ROWS ; i++) {
        if ( i == 0 ) {
          result[i][j] = matrix[i][j] ;
        } else {
          result [i][j] = matrix[i][j] + result[i - 1][j] ;
        }
      }
    }
    return result ;
  }
  private static int largestSubarraySum (int[] cur) {

    int pre = cur[0] ;
    int globalMax = cur[0] ;

    for ( int i = 1; i < cur.length ; i++) {
      if ( pre > 0) {
        pre = pre + cur[i] ;
      } else {
        pre = cur[i] ;
      }
      globalMax = Math.max(globalMax, pre ) ;
    }
    return globalMax ;
  }
}
