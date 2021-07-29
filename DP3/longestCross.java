package DP3;

public class longestCross {

  public static void main(String [] args) {
    int[][] matrix = new int[][] { {1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1} } ;
    System.out.println(myLongestCross(matrix) ) ;
  }


  public static int myLongestCross(int[][] matrix) {

    int N = matrix.length ;
    int M = matrix[0].length ;
    if ( N == 0 || M == 0) {
      return 0 ;
    }
    int[][] up = fillUp(matrix) ;
    int[][] left = fillLeft(matrix);
    int[][] down = fillDown(matrix) ;
    int[][] right = fillRight(matrix) ;
    int[][] Memo = new int[N][M] ;
    int globalMax = Integer.MIN_VALUE ;

    System.out.println("memo") ;

    for (int i = 0; i < N ; i++) {
      for (int j = 0 ; j < M; j ++) {
        Memo[i][j] = Math.min(up[i][j], left[i][j]) ;
        Memo[i][j] = Math.min(Memo[i][j], down[i][j]) ;
        Memo[i][j] = Math.min(Memo[i][j], right[i][j]) ;
        globalMax = Math.max(globalMax, Memo[i][j]) ;
        System.out.print( Memo[i][j] + " " ) ;
      }
      System.out.println() ;
    }
    return globalMax ;
  }

  public static int[][] fillUp(int[][] matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;

    int[][] up = new int[N][M] ;
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M; j ++) {
        if( i == 0 ) {
          up[i][j] = matrix[i][j] ;
          continue;
        }
        if( matrix[i][j] == 0 ) {

          up[i][j] = 0 ;
        } else {
          up[i][j] = up[i - 1][j] + 1 ;
        }
      }
    }
    System.out.println("UP: ");
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M ; j++) {
        System.out.print(up[i][j] + " ");
      }
      System.out.println() ;
    }
    return up;
  }

  public static int[][] fillLeft(int[][] matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;

    int[][] left = new int[N][M] ;
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M; j ++) {
        if( j == 0 ) {
          left[i][j] = matrix[i][j] ;
          continue;
        }
        if( matrix[i][j] == 0 ) {
          left[i][j] = 0 ;
        } else {
          left[i][j] = left[i ][j - 1] + 1 ;
        }
      }
    }
    System.out.println("Left: ");
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M ; j++) {
        System.out.print(left[i][j] + " ");
      }
      System.out.println() ;
    }
    return left;
  }

  public static int[][] fillDown(int[][] matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;

    int[][] Down = new int[N][M] ;

    for (int i = N - 1 ; i >= 0; i --) {
      for (int j = M - 1 ; j >= 0; j --) {
        if( i == N - 1 ) {
          Down[i][j] = matrix[i][j] ;
          continue;
        }
        if( matrix[i][j] == 0 ) {
          Down[i][j] = 0 ;
        } else {
          Down[i][j] = Down[i + 1][j ] + 1 ;
        }
      }
    }
    System.out.println("Down: ");
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M ; j++) {
        System.out.print(Down[i][j] + " ");
      }
      System.out.println() ;
    }
    return Down ;
  }


  public static int[][] fillRight(int[][] matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;

    int[][] Right = new int[N][M] ;

    for (int i = N - 1 ; i >= 0; i --) {
      for (int j = M - 1 ; j >= 0; j --) {
        if( j == M - 1 ) {
          Right[i][j] = matrix[i][j] ;
          continue;
        }
        if( matrix[i][j] == 0 ) {
          Right[i][j] = 0 ;
        } else {
          Right[i][j] = Right[i][ j + 1] + 1 ;
        }
      }
    }
    System.out.println("Right: ");
    for (int i = 0 ; i < N; i ++) {
      for (int j = 0 ; j < M ; j++) {
        System.out.print(Right[i][j] + " ");
      }
      System.out.println() ;
    }
    return Right ;
  }


}
