package DP;

public class MaxProduct {

  public static void main(String[] args) {

    System.out.println( maxProduct2(8) );
  }


  public static int maxProduct1(int length) {
    // Write your solution here
    if ( length == 1) {
      return 1;
    }
    int globalMax= 0;
    for ( int i = 1; i < length ; i ++) {
      int cur = Math.max(maxProduct1(i), i )  ;
      globalMax = Math.max( globalMax, cur * ( length - i ) ) ;
    }
    return globalMax;
  }

  public static int getMaxProduct(int n ) {
    //Long base case
    if ( n <= 1) {
      return 0;
    }
    int globalMax = 0;
    for (int i = n - 1; i >= 1 ; i-- ) {
      int best = Math.max( getMaxProduct(i), i ) ;

      globalMax = Math.max( best * (n - i ) , globalMax );
    }
    return globalMax ;
  }
  public static int curRope(int n) {
    int[] M = new int[n + 1] ;
    M[0] = 0;
    M[1] = 0;
    for (int i = 2; i <= n ; i++) {
      int curMax = 0 ;
      for (int j = 1 ; j < i; j ++) {
        curMax = Math.max( curMax , Math.max(j, M[j]) * (i - j )  ) ;
      }
      M[i] = curMax ;
    }
    return M[n] ;
  }
  public static int maxProduct2(int length) {
    int[] M = new int[length + 1] ;

    M[0] = 0;
    M[1] = 0;
    for (int i = 2; i <= length; i++) {
      for ( int j = 1 ; j < i; j ++) {
        int cur = Math.max(M[j], j ) * (i - j) ;
        M[i] = Math.max(M[i], cur ) ;
      }

    }
    return M[length] ;
  }

}
