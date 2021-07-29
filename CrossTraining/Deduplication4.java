package CrossTraining;

import java.util.Arrays;

public class Deduplication4 {

    public static void main(String [] args) {
        int[] arr = new int[] {1,1,2,3,3,4,5,5,5} ;
        arr = dedup(arr);
        for (int i: arr) {
          System.out.print(i+" ") ;
        }
    }


  public static int[] dedup(int[] array) {
    // Write your solution here
    if (array.length <= 1) {
      return array ;
    }
    int slow = 1;
    for (int fast = 1 ; fast < array.length ;  fast ++) {
      if ( slow != 0 && array[fast] == array[slow - 1] ) {
        while ( fast < array.length && array[fast] == array[slow - 1] ){
          fast++ ;
        }
        slow-- ;
        fast--;
        continue;
      }
      array[slow++] = array[fast] ;
    }
    return Arrays.copyOf(array, slow) ;
  }
}
