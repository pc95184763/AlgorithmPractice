package BinarySearch;

public class SearchInShiftedSortedArrayWithDuplicate {

  public static void main(String []args) {

    int []  array = new int[] {1,1,2,1} ;
    System.out.println( search ( array, 2) );

  }

  public static int search(int[] array, int target) {
    // Write your solution here
    if ( array == null || array.length == 0) {
      return -1 ;
    }
    int left = 0;
    int right = array.length - 1;
    while ( left < right) {
      int mid = left + (right - left) / 2;
      if ( array[mid] > array[right] ) {
        left = mid + 1;
      } else {
        right = mid ;
      }
    }

    int rotate = left ;

    int leftResult = findFirstOccurence(array,0, rotate - 1, target) ;
    int rightResult = findFirstOccurence(array, rotate, array.length - 1, target) ;
    if ( leftResult == -1 && rightResult == -1) {
      return -1;
    }
    if ( leftResult == -1 || rightResult == -1) {
      return leftResult == -1? rightResult : leftResult ;
    }
    return Math.min(leftResult, rightResult) ;
  }
  // return -1 if doesn't exist
  public static int findFirstOccurence(int[] array, int left, int right, int target) {
    if ( right < left) {
      return -1;
    }
    while ( left < right - 1) {
      int mid = left + (right - left) / 2;
      if ( array[mid] < target ) {
        left = mid + 1;
      }
      else if ( array[mid] == target) {
        right = mid ;
      } else {
        right = mid - 1;
      }
    }
    if ( array[left] == target) {
      return left ;
    }
    if ( array[right] == target) {
      return right ;
    }
    return -1;
  }

}
