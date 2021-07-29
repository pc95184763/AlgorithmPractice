package DFS2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeepDistance {

  public static void main(String[] args) {


  }


  public int[] keepDistance(int k) {
    // Write your solution here.
    int[] result = new int[2 * k] ;
    for (int i = 0 ; i < result.length - 1; i += 2) {
      result[i] = i + 1;
      result[i + 1] = i + 1;
    }
    Set<Integer> map = new HashSet<>() ;
    DFS(0, map, result) ;
    return result ;
  }

  private void DFS (int index, Set<Integer> map, int[] result ) {


  }

}
