package DFS;
import java.util.* ;

public class CombinationOfCoins {

  public static void main(String[] arg) {
    int[] coins = new int[] {25, 10 , 5, 1} ;
    List<List<Integer>> result = combinations(10, coins ) ;
    for (List i: result){
      System.out.print(i + " ") ;
    }
  }

  public static List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>> () ;
    List<Integer> buf = new ArrayList<>() ;
    helper(target, coins, buf, 0,result) ;
    return result;

  }
  //[0, 0, 0, 10] [0, 0, 1, 5] [0, 0, 2, 0] [0, 1, 0, 0]
  //[0, 0, 0, 10] [0, 0, 0, 1, 5] [0, 0, 0, 1, 2, 0] [0, 0, 0, 1, 1, 0, 0]
  static void  helper( int target, int[] coins, List<Integer> buf, int index, ArrayList<List<Integer>> result) {
    if ( index == coins.length - 1) {
      if( target % coins[index] == 0) {
        buf.add( target / coins[index] ) ;
        result.add( new ArrayList<>(buf)) ;
//        buf.remove(buf.size() - 1) ;
      }
      return ;
    }

    for (int i = 0; i <= target / coins[index] ; i ++) {
      buf.add(i) ;
      helper(target - coins[index] * i, coins, buf, index + 1 , result) ;
      buf.remove(buf.size() - 1) ;
    }
  }

  private void DFS(int index ,int[] coins, int target, List<Integer> cur, List<List<Integer>> result) {
    if ( index == coins.length - 1  ) {
      if ( target % coins[index] == 0  ) {
        cur.add( target / coins[index] ) ;
        result.add(new ArrayList<> (cur) ) ;

      }
      return ;
    }
  }
}
