package DP;

public class LongestArray {

  public static void main(String[] args) {
    int[] test = {9, 9};
    System.out.println(longest1(test) ) ;
  }


  public static int longest(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    if (array.length == 1){
      return 1;
    }
    int globalMax = 0 ;
    int counter = 1;
    int[] M = new int[array.length + 1] ;
    M[0] = 1 ;
    for (int i = 1 ; i < array.length; i ++) {
      if ( array[i] > array[i - 1]) {
        M[i] = ++counter ;
      }else {
        counter = 1;
        M[i] = counter ;
      }
      globalMax = counter > globalMax? counter: globalMax ;
    }
    return globalMax ;
  }


  public static int longest1(int[] array) {
    // Write your solution here
    if ( array.length == 1) {
      return 1 ;
    }
    int [] M = new int[ array.length ] ;
    int globalMax = 0;
    int counter = 1;
    M[0] = 1 ;
    for ( int i = 1 ; i < M.length ; i++ ) {
      if ( array[i] > array[i - 1] ){
        M[i] = ++counter ;
      }
      else {
        counter = 1;
        M[i] = counter ;
      }
      globalMax = M[i] > globalMax ? M[i] : globalMax ;

    }

    return globalMax ;

  }
}
