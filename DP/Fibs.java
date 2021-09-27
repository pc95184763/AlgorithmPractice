package DP;

public class Fibs {

  public static void main(String[] ar) {
    System.out.println(fibo(5) ) ;
  }

  //memorization
  public static long fibo(int K) {
    if ( K < 0) {
      return 0 ;
    }
    Long[] M = new Long[K + 1] ;
    fibonacci(K, M) ;
    return M[K] ;
  }
  public static long fibonacci(int K, Long[] M) {
    // Write your solution here
    if ( K == 0 || K == 1) {
      return K ;
    }
    if ( M[K] != null ) {
      return M[K] ;
    }
    M[K] = fibonacci(K - 1, M) + fibonacci(K - 2, M) ;
    return M[K] ;
  }

}
