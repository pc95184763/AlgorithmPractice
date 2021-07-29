package BinarySearch;

public class SearchInMatrix {


  public static void main(String []args) {



    int [][] array = new int[][]{{1,2,3,4}};
    int rows = array.length ;
    int cols = array[0].length ;
    int [] arr = search(array,4 ) ;
    System.out.println( arr[0]+" " + arr[1]);
  }


  public static int[] search(int[][] matrix, int target) {
    // Write your solution here

    int rows = matrix.length ;
    int cols = matrix[0].length ;
    int right = rows * cols - 1;
    int left = 0 ;
    while (left <= right) {
      int mid = left + (right - left) / 2 ;
      if ( matrix[mid / cols][ mid % cols ] == target ) {
        return new int[]{ mid / cols, mid % cols } ;
      }
      else if ( matrix[mid / cols][ mid % cols ] > target) {
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }
    return new int[]{-1, -1};
  }
}
