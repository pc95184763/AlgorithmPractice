package Recursion2;
import java.util.* ;

public class NQueues1 {

  public static void main(String[] args) {
    System.out.println( nqueens(8) ) ;
  }



  public static List<List<Integer>> nqueens(int n) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int[] cur = new int[n] ;
    boolean[] usedColumns = new boolean[n] ;
    boolean[] usedDiagnoals = new boolean[2 * n - 1];

    boolean[] usedRevDiagonals = new boolean[2 * n - 1] ;
    helper(n, 0, cur, result, usedColumns, usedDiagnoals, usedRevDiagonals) ;

    return result;
  }

  private static void helper( int n, int row, int [] cur, List<List<Integer>> result,
      boolean[] usedColumns, boolean[] usedDiagnoals, boolean[] usedRevDiagonals) {
    if (row == n) {
      result.add(toList(cur) ) ;
      return ;
    }
    for (int i = 0; i < n ; i ++) {
      if (valid(n, row, i, usedColumns, usedDiagnoals, usedRevDiagonals) ) {
        mark( n, row, i, usedColumns, usedDiagnoals, usedRevDiagonals ) ;
        cur[row] = i;
        helper(n, row + 1, cur, result, usedColumns, usedDiagnoals, usedRevDiagonals) ;
        unMark( n, row, i, usedColumns, usedDiagnoals, usedRevDiagonals ) ;
      }

    }
  }

  private static boolean valid(int n , int row, int column, boolean [] usedColumns, boolean[] usedDiagnoals,
  boolean []usedRevDiagonals) {

    return  !usedColumns[column ] && !usedDiagnoals[column + row] && !usedRevDiagonals[column - row + n - 1] ;
  }

  private  static void mark ( int n, int row, int column, boolean[] usedColumns,
      boolean[] usedDiagnoals, boolean[] usedRevDiagonals ) {

    usedColumns[column] = true ;
    usedDiagnoals[column + row] = true;

    usedRevDiagonals[column - row + n -1] = true;

  }

  private static void unMark( int n, int row, int column, boolean[] usedColumns,
      boolean[] usedDiagnoals, boolean[] usedRevDiagonals )  {

    usedColumns[column] = false;
    usedDiagnoals[column + row] = false;
    usedRevDiagonals[column - row + n - 1] = false ;

  }

  private static List<Integer> toList(int [] array) {
    List<Integer> list = new ArrayList<>() ;

    for (int num : array) {
      list.add(num) ;
    }
    return list ;
  }








}
