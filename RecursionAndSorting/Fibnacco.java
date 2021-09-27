package RecursionAndSorting;

public class Fibnacco {

  public static void main(String [] args) {
    System.out.println( fibonacci(6) );




  }


  public static long fibonacci(int K) {
    // Write your solution here
    if ( K < 0) {
      return 0 ;
    }
    if ( K == 0 || K == 1) {
      return K;
    }
    Long [] M = new Long [K + 1] ;
    return fib(K, M) ;
  }

  private static long fib ( int K, Long [] memo) {
    if ( K < 0) {
      return 0 ;
    }
    if ( K == 0 || K == 1) {
      return K;
    }
    if ( memo[K] == null) {
      return fib(K - 1, memo) + fib(K - 2, memo) ;
    } else {
      return memo[K] ;
    }
  }

}
