package DFS2;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

  public static void main(String[] args) {

    List<List<Integer>> list= combinations(12) ;

    for (List<Integer> l: list) {
      System.out.println(l) ;
    }

//    List<Integer> list =  getFactors(12) ;
//    for (Integer i : list) {
//      System.out.print(i + " " ) ;
//    }
  }



  public static List<List<Integer>> combinations(int target) {
    List<List<Integer>> result = new ArrayList<>() ;
    if (target <= 1) {
      return result;
    }
    List<Integer> cur = new ArrayList<>() ;
    List<Integer> factors = getFactors(target) ;
    helper(target, factors, 0, cur, result) ;
    return result ;
  }


  private static void helper(int target, List<Integer> factors, int index,
      List<Integer> cur, List<List<Integer>> result) {

    if (index == factors.size() ) {
      if (target == 1) {
        result.add(new ArrayList<>(cur) ) ;
      }
      return ;
    }
    helper(target, factors, index + 1, cur, result) ;
    int factor = factors.get(index) ;
    int size = cur.size() ;
    while (target % factor == 0) {
      cur.add(factor);
      target /= factor ;
      helper(target, factors, index + 1, cur, result) ;
    }
    cur.subList(size, cur.size()).clear()  ;
  }

  private static List<Integer> getFactors(int target) {
    List<Integer> factors = new ArrayList<>() ;
    for (int i = target / 2; i > 1 ; i --) {
      if (target % i == 0) {
        factors.add(i) ;
      }
    }
    return factors;
  }

}
