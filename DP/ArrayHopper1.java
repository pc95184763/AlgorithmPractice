package DP;

public class ArrayHopper1 {

  public static void main(String [] args) {
    int[] test = {0,1} ;

    System.out.println( canJump( test ) ) ;
  }


  public static boolean canJump(int[] array) {
    // Write your solution here
    if (array.length == 1) {
      return true;
    }
    boolean M[] = new boolean[ array.length] ;
    //base case
    M[M.length - 1] = true ;
    for ( int i = M.length - 2 ; i >=0 ; i --) {
      for ( int j = i + 1; j <= array.length - 1 ; j++) {
        if ( M[j] == true && i + array[i] >= j ) {
          M[i] = true;
          break ;
        }
      }

    }
    return M[0];
  }
}
