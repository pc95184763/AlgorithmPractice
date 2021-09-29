package BinarySearch;

public class SearchInShiftedSortedArray {

  public static void main(String []args) {

    int []  array = new int[] {15,19,22,1,3,6,10,11,14} ;
    System.out.println( search ( array, 19) );

  }

  public static int search(int[] array, int target) {
    // Write your solution here
    // 3  4   5    1    2
    // array[mid]
    int left = 0;
    int right = array.length - 1;
    while ( left < right) {
      int mid = left + (right - left) / 2;
      if ( array[mid] > array[right] ) {
        left = mid + 1;
      }
      else {
        right = mid ;
      }
    }

    int rotate = left ;
    left = 0;
    right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int realMid = ( mid + rotate ) % array.length ;
      if ( array[realMid] == target) {
        return realMid ;
      }
      if (array[realMid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
