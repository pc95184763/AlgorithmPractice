package CrossTraining;

import java.util.Arrays;

public class ArrayDeduplication1 {

  public static void main(String[] args) {
    int[] array = new int[] {1} ;
    array = dedup(array);
    for( int i : array) {
      System.out.print ( i + " ");
    }

  }

  public static int[] dedup(int[] array) {
    // Write your solution here
    if( array.length == 0) {
      return array ;
    }

    int slow = 1;
    for (int fast = 1; fast < array.length ; fast++) {
      if ( array[fast] == array[slow - 1] ) {
        continue ;
      }
      array[slow++] = array[fast] ;
    }
    return Arrays.copyOf(array, slow) ;
  }
}
