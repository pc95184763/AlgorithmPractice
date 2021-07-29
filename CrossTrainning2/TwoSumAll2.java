package CrossTrainning2;

import java.util.*;

public class TwoSumAll2 {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer> > result = new ArrayList<List<Integer> >() ;
    Arrays.sort(array) ;
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      if( array[left] + array[right] > target) {
        right--;
      }
      else if (array[left] + array[right] < target) {
        left++ ;
      }
      else {
        List<Integer> cur = new ArrayList<Integer>() ;
        cur.add(left) ;
        cur.add(right) ;
        result.add( cur) ;
      }
    }

    return result;
  }
}
