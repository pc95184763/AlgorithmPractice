package DP;

public class ArrayHopper2 {
  public static void main (String[] args) {
     int[] arr = {3, 3, 1, 0, 4} ;
      System.out.println( minJump(arr) );
  }

  public static int minJump(int[] array) {
    // Write your solution here
    int[] M = new int [array.length] ;
    M[M.length - 1] = 0;

    for (int i = M.length - 2 ; i >= 0; i--) {
      M[i] = -1;
      for (int j = i + 1; j <= M.length - 1 ; j++ ) {
        if ( j - i <= array[i] && M[j] != -1 ) {
          if ( M[i] == -1 || M[i] > M[j] + 1 ) {
            M[i] = M[j] + 1;
          }
        }
      }
    }
    return M[0] ;
  }
}
