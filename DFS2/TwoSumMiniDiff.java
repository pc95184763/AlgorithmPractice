package DFS2;

public class TwoSumMiniDiff {

  public static void main(String[] args) {
    int[] arr = new int[] {-2,-9,-3,-1,-1} ;
    System.out.print( minDifference(arr)) ;
  }

  public static int minDifference(int[] array) {
    // Write your solution here
    int sum = 0 ;
    int k = array.length ;
    for (int i = 0 ; i < array.length ; i ++) {
      sum += array[i] ;
    }
    int[] minDiff = new int[] {Integer.MAX_VALUE} ;

    DFS(0, k / 2, minDiff, 0, sum / 2, array) ;
    if ( sum % 2 == 0) {
      return  2 * minDiff[0]  ;
    }
    return 2 * minDiff[0] + 1 ;
  }
  private static void DFS(int index, int k, int[] minDiff, int curSum , int halfSum, int[] array) {
    if ( k == 0   ) {
      minDiff[0] = Math.min(minDiff[0], Math.abs(halfSum - curSum) ) ;
      return ;
    }
    if (index == array.length) {
      return ;
    }
    DFS(index + 1, k - 1, minDiff, curSum + array[index], halfSum, array) ;
    DFS(index + 1, k , minDiff, curSum , halfSum, array) ;
  }
}
