package RecursionAndSorting;

public class Merge {

  public static void main(String [] args) {

    int[] arr = new int[] {3,5,1,2,4,8} ;
    arr = mergeSort(arr) ;
    for (int i : arr) {
      System.out.print(i + " ") ;
    }
  }


  public static int[] mergeSort(int[] array) {
    // Write your solution here
    if ( array == null || array.length == 0) {
      return array ;
    }

    int[] helper = new int[array.length] ;
    for (int i = 0 ; i < helper.length ; i++ ) {
      helper[i] = array[i] ;
    }

    mergeSort(array, 0, array.length - 1, helper) ;
    return array ;
  }

  private static void mergeSort(int [] array, int left, int right, int[] helper) {
    if (left == right ) {
      return   ;
    }
    int mid = left + (right - left) / 2;

    mergeSort( array, left, mid, helper) ;
    mergeSort( array, mid + 1, right, helper) ;

    merge(array, left, mid, right, helper)  ;
  }
  private static void merge (int [] array, int left, int mid, int right, int[] helper) {

    int i = left ;
    int j = mid + 1 ;
    int cur = left ;
    while ( i <= mid && j <= right) {
      if ( helper[i] < helper[j]) {
        array[cur++] = helper[i++] ;
      } else {
        array[cur++ ] = helper[j++] ;
      }
    }
    while (i <= mid) {
      array[cur++] = helper[i++] ;
    }

  }
}
