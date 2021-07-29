package CrossDIY;

public class SearchInShift21 {

  public static void main( String[] args) {
    int[] arr = new int[] {20,30,2,12,13,14,15} ;
    System.out.println(search(arr, 30) ) ;
  }

  public static int search(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int divider = 0 ;
    for (int i = 0 ; i < array.length - 1; i ++) {
      if ( array[i + 1] < array[i] ) {
        break ;
      }
      divider++ ;
    }
    int leftResult = binarySearch(array, 0, divider, target) ;
    int rightResult = binarySearch(array, divider + 1, array.length - 1, target) ;
    if ( leftResult == -1 && rightResult == -1) {
      return -1;
    }
    return leftResult == -1? rightResult: leftResult ;
  }

  private static int binarySearch(int[] array, int left, int right, int target) {

    while(left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid ;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
