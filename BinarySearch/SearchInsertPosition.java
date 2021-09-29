package BinarySearch;

public class SearchInsertPosition {
  public int searchInsert(int[] array, int target) {
    // Write your solution here
    // ssss  eeee  bbbb
    // case1: array[mid] == s : left = mid;
    // case2 : array[mid] == e : right = mid;
    // case3 : array[mid] == b :
    if ( array == null || array.length == 0) {
      return 0;
    }

    int left = 0;
    int right = array.length - 1;

    while ( left < right - 1) {
      int mid = left + (right - left) / 2;
      if ( array[mid] < target ) {
        left = mid ;
      } else if (array[mid] >= target) {
        right = mid;
      }
    }
    if ( array[left] >= target) {
      return left ;
    } else if ( array[right] >= target) {
      return right ;
    }
    if ( target > array[right]) {
      return right + 1;
    }
    return -1;
  }
}
