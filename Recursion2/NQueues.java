package Recursion2;
import java.util.* ;
public class NQueues {

  public static void main(String[] args) {
    List<List<Integer>> result = nQuenes(8) ;
    for (List i : result) {
      System.out.print(i) ;
    }
  }


  public static List<List<Integer>> nQuenes (int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>() ;
    List<Integer> cur = new ArrayList<>() ;

    helper(n , cur, result) ;
    return result;
  }

  static void  helper( int n ,List<Integer> cur, List<List<Integer>> result) {
    //base case
    if ( n == cur.size()  ) {
      result.add(new ArrayList<Integer>(cur) ) ;
      return ;
    }
    for (int i = 0 ; i < n; i++ ) {
      if (valid(cur, i) ) {
        cur.add(i)  ;
        helper( n, cur, result) ;
        cur.remove(cur.size() - 1 ) ;
      }
    }
  }

  static boolean  valid (List<Integer> cur, int position ) {
    int rows = cur.size() ;

    for (int i = 0 ; i < rows; i ++) {
      if ( position == cur.get(i) || Math.abs(position - cur.get(i) ) == rows - i ) {
        return false;
      }
    }
    return true;

  }
}
