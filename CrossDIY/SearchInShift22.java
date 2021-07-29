package CrossDIY;

public class SearchInShift22 {

  public static void main(String[] args) {
    int[] arr = new int[] {886,887,888,889,891} ;
    System.out.println(search(arr, 886 ) ) ;
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
    if (leftResult == -1 || rightResult == -1) {
      return leftResult == -1? rightResult: leftResult ;
    }
    return leftResult < rightResult ? leftResult : rightResult ;
  }

  private static int binarySearch(int[] array, int left, int right, int target) {
    //sssss   eeee   bbbb
    if (left >= array.length ) {
      return -1;
    }

    while(left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid ;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    if (array[left] == target) {
      return left ;
    }else if (array[right] == target) {
      return right ;
    }

    return -1;
  }
}
