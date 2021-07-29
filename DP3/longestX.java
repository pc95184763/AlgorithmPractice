package DP3;

public class longestX {


  public int largest (int[][] matrix) {

    int N = matrix.length ;
    int M = matrix[0].length ;

    if ( N == 0 || M == 0) {
      return 0;
    }


    int[][] leftUp = fillLeftUp(matrix) ;
    int[][] leftDown = fillLeftDown(matrix) ;
    int[][] rightUp = fillRightUp(matrix) ;
    int[][] rightDown = fillRightDown(matrix) ;

    int [][] result = new int[N][M];

    int globalMax = Integer.MIN_VALUE ;

    for (int i = 0 ; i < N; i++) {
      for (int j = 0 ; j < M; j++) {
        result[i][j] = Math.min(leftUp[i][j] , leftDown[i][j]) ;
        result[i][j] = Math.min(result[i][j], rightUp[i][j]) ;
        result[i][j] = Math.min(result[i][j], rightDown[i][j]) ;
        globalMax = Math.max( globalMax, result[i][j] ) ;
      }
    }

    return globalMax ;
  }

  public int[][] fillLeftUp(int [][]matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;
    int [][] leftUp = new int[N][M] ;

    for ( int i = 0 ; i < N ; i++ ){
      for (int j = 0 ; j < M ; j ++) {
        if ( i == 0) {
          leftUp[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( j == 0) {
          leftUp[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( matrix[i][j] == 0) {
          leftUp[i][j] = 0;
        } else {
          leftUp[i][j] = leftUp[i - 1][j - 1]  + 1;
        }
      }
    }
    return leftUp ;
  }

  public int[][] fillLeftDown(int [][]matrix ) {
    int N = matrix.length ;
    int M = matrix[0].length ;
    int [][] leftDown = new int[N][M] ;

    for ( int i = N - 1; i >= 0; i --) {
      for (int j = 0; j < M ; j ++) {
        if ( i == N - 1 ) {
          leftDown[i][j] = matrix[i][j] ;
          continue;
        }
        if ( j == 0) {
          leftDown[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( matrix[i][j] == 0) {
          leftDown[i][j] = 0;
        } else {
          leftDown[i][j] = leftDown[i + 1][j - 1]  + 1;
        }

      }
    }
    return leftDown ;
  }

  public int[][] fillRightUp(int [][]matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;
    int [][] rightUp = new int[N][M] ;

    for ( int i = 0 ; i < N ; i++ ){
      for (int j = M - 1 ; j >= 0 ; j--) {
        if ( i == 0) {
          rightUp[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( j == M - 1) {
          rightUp[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( matrix[i][j] == 0) {
          rightUp[i][j] = 0;
        } else {
          rightUp[i][j] = rightUp[i - 1][j + 1]  + 1;
        }
      }
    }
    return rightUp ;
  }

  public int[][] fillRightDown(int [][]matrix) {
    int N = matrix.length ;
    int M = matrix[0].length ;
    int [][] rightDown = new int[N][M] ;

    for ( int i = N - 1 ; i >= 0 ; i-- ){
      for (int j = M - 1 ; j >= 0 ; j--) {
        if ( i == N - 1) {
          rightDown[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( j == M - 1) {
          rightDown[i][j] = matrix[i][j] ;
          continue ;
        }
        if ( matrix[i][j] == 0) {
          rightDown[i][j] = 0;
        } else {
          rightDown[i][j] = rightDown[i + 1][j + 1]  + 1;
        }
      }
    }
    return rightDown ;
  }












}
