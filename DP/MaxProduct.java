package DP;

public class MaxProduct {

  public static void main(String[] args) {
    System.out.println( maxProductMemo(8) );
  }
  // DFS
  public static int maxProductDFS(int length) {
    // Write your solution here
    if (length == 1) {
      return 1 ;
    }
    int[] M = new int[length] ;
    int max = 0;
    for (int i = length - 1; i >= 1 ; i--) {
      int cur = Math.max(i, maxProductDFS(i) ) * ( length - i );
      max = Math.max(max, cur) ;
    }
    return max ;
  }

  // Memorization
  public static int maxProductMemo(int length) {
    if (length == 0 || length == 1) {
      return length ;
    }
    int[] memo = new int[length + 1] ;
    maxProductMemo(length, memo) ;
    return memo[length] ;
  }
  public static int maxProductMemo(int length, int [] memo) {
    if (length == 0 || length == 1) {
      return length ;
    }
    if ( memo[length] != 0) {
      return memo[length] ;
    }
    int curMax = 0;
    for (int i = length - 1 ; i >= 1 ; i--) {
      int cur = Math.max(i, maxProductMemo(i, memo) ) * (length - i);
      curMax = Math.max(curMax, cur) ;
    }
    memo[length] = curMax ;
    return curMax ;
  }


  //DP
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


}
