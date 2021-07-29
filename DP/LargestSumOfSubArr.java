package DP;

public class LargestSumOfSubArr {

  public static void main(String[] args) {
    int[] arr = {1,2,4,-1, -2, 20, -1} ;
    System.out.println(getMax(arr) ) ;
  }


  public static int getMax(int[] input) {
    int[] M = new int[input.length] ;
    M[0] = input[0] ;
    int globalMax = input[0] ;

    for (int i = 1; i < input.length; i ++) {
      M[i] =  Math.max( input[i] , M[i - 1] + input[i] ) ;
      globalMax = Math.max(globalMax, M[i]) ;
    }

    return globalMax ;
  }

}
