package DP;

public class Fibs {

  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 0) {
      return 0;
    }
    long [] fibsFound = new long[K + 1] ;
    fibsFound[0] = 0;
    fibsFound[1] = 1;
    for ( int i = 2; i <= K ; i++) {
      fibsFound[i] = fibsFound[i - 1] + fibsFound[i -2] ;
    }
    return fibsFound[K] ;
  }
  public long fibonacci1(int K) {
    // Write your solution here
    if ( K < 0) {
      return 0;
    }
    if ( K == 0 || K == 1) {
      return K ;
    }
    long[] array = new long[K + 1] ;
    array[0] = 0;
    array[1] = 1;

    for (int i = 2; i <= K; i++) {
      array[i] = array[i - 1] + array[i - 2] ;
    }

    return array[K] ;
  }
  public long fibonacci2(int K) {
    // Write your solution here
    if ( K <= 0) {
      return 0;
    }
    long first = 0;
    long second = 1;

    while (K > 1) {
      long temp = first + second;
      first = second;
      second = temp;
      K--;
    }
    return second;
  }

}
