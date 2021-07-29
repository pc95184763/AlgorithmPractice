package DP;

public class EditDistance {

  public static void main(String[] args) {
      String one = "asdf" ;
      String two = "sghj" ;

      System.out.println(editDistancehahah(one, two)  ) ;
  }
  public static int editDistancehahah(String one, String two) {
    // Write your solution here
    if (one.length() == 0) {
      return two.length() ;
    }
    if (two.length() == 0) {
      return one.length() ;
    }
    int rows = one.length() ;
    int cols = two.length() ;
    int[][] M = new int[rows + 1][cols + 1] ;

    for (int i = 0 ; i <= rows ; i ++ ) {
      for (int j = 0 ; j <= cols ; j++) {
        if (i == 0) {
          M[i][j] = j ;
        }
        else if (j == 0) {
          M[i][j] = i ;
        }
        else if (one.charAt(i - 1) == two.charAt(j - 1) ) {
          M[i][j] = M[i - 1][j - 1] ;
        } else {
          M[i][j] = Math.min(M[i -1][j - 1] + 1, M[i][j - 1] + 1) ;
          M[i][j] = Math.min(M[i][j] , M[i - 1][j ] + 1) ;
        }
      }
    }


    return M[M.length - 1][M[0].length - 1] ;
  }


}
