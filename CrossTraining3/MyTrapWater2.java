package CrossTraining3;

public class MyTrapWater2 {

  public static void main(String [] args) {
      int[][] matrix = { { 5,8,7,7},

          { 5,2,1,5 },

          { 7,1,7,1 },
          {8,9,6,9},
          {9,8,9,9}
      } ;
// 5,8,7,7],[5,2,1,5],[7,1,7,1],[8,9,6,9],[9,8,9,9
      int[][] arr = lookRight(matrix) ;
      for (int i = 0 ; i < arr.length ; i ++) {
        for (int j = 0 ; j < arr[i].length ; j ++) {
          System.out.print(arr[i][j] + " " );
        }
        System.out.println();
      }
  }



  private static int[][] lookUp (int[][] matrix) {
    int[][] result = new int[matrix.length][] ;
    for (int i = 0 ; i < matrix.length ; i ++) {
      result[i] = new int[ matrix[i].length ] ;
    }
    for (int i = 0 ; i < matrix.length; i ++) {
      for ( int j = 0 ; j < matrix[i].length; j++) {
        if ( i == 0) {
          result[i][j] = matrix[i][j] ;
        } else  {
          result[i][j] = Math.max( result[i - 1][j] , matrix[i][j] ) ;
        }
      }
    }
    return result ;
  }

  private static int[][] lookDown (int[][] matrix) {
    int[][] result = new int[matrix.length][] ;
    for (int i = 0 ; i < matrix.length ; i ++) {
      result[i] = new int[ matrix[i].length ] ;
    }
    for (int i = matrix.length - 1 ; i >= 0; i --) {
      for ( int j = 0 ; j < matrix[i].length; j++) {
        if ( i == matrix.length - 1) {
          result[i][j] = matrix[i][j] ;
        } else  {
          result[i][j] = Math.max( result[i + 1][j] , matrix[i][j] ) ;
        }
      }
    }
    return result ;
  }

  private static int[][] lookLeft (int[][] matrix) {
    int[][] result = new int[matrix.length][] ;
    for (int i = 0 ; i < matrix.length ; i ++) {
      result[i] = new int[ matrix[i].length ] ;
    }
    for (int i = 0 ; i < matrix.length ; i ++) {
      for ( int j = 0 ; j < matrix[i].length; j++) {
        if ( j == 0) {
          result[i][j] = matrix[i][j] ;
        } else  {
          result[i][j] = Math.max( result[i][j - 1] , matrix[i][j] ) ;
        }
      }
    }
    return result ;
  }
  private static int[][] lookRight (int[][] matrix) {
    int[][] result = new int[matrix.length][] ;
    for (int i = 0 ; i < matrix.length ; i ++) {
      result[i] = new int[ matrix[i].length ] ;
    }
    for (int i = 0 ; i < matrix.length ; i ++) {
      for ( int j = matrix[i].length - 1 ; j >= 0 ; j--) {
        if ( j == matrix[i].length - 1 ) {
          result[i][j] = matrix[i][j] ;
        } else  {
          result[i][j] = Math.max( result[i][j + 1] , matrix[i][j] ) ;
        }
      }
    }
    return result ;
  }
}
