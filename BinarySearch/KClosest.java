package BinarySearch;

public class KClosest {
  public static void main(String [] args) {

    int[] arr = new int[] {1} ;

    arr = kClosest(arr, 0 , 1) ;

  }

  public static int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array == null || array.length == 0 || k > array.length ) {
      return array;
    }
    int left  = largestSmallEqual( array, target) ;
    int right = left + 1 ;
    int[] result = new int[k] ;

    for (int i = 0 ; i < result.length; i ++ ){
      if ( right >= array.length ||  Math.abs( array[left] - target ) <= Math.abs( array[right] - target ) ) {
        result[i] = array[left--] ;
      } else {
        result[i] = array[right++] ;
      }

    }
    return result;
  }

  public static int largestSmallEqual (int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    // sssss   eeeeE  bbbbbbb
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid ;
      }
      else if ( array[mid] > target) {
        right = mid - 1;
      }
      else {
        left = mid ;
      }
    }
    if ( array[right] <= target ){
      return right ;
    }  else if (array[left] <= target)  {
      return left ;
    }
    return -1;
  }

}
