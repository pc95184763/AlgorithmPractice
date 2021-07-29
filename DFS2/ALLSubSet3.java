package DFS2;

import java.util.*;


public class ALLSubSet3 {


  public List<String> subSets(String set) {

    List<String> result = new ArrayList<String>() ;
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray() ;

    Arrays.sort(array) ;
    StringBuilder sb = new StringBuilder() ;

    helper(array, sb, 0, result) ;
    return result;
  }
  private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
    if (index == set.length) {
      result.add(sb.toString() ) ;
      return ;
    }
    helper(set, sb.append(set[index]), index + 1, result ) ;
    sb.deleteCharAt(sb.length() - 1) ;
    while ( index < set.length - 1 && set[index] == set[index + 1]) {
      index ++ ;
    }
    helper(set,sb, index + 1, result) ;

  }

  private void helper1(int index, char[] array, StringBuilder sb, List<String> result) {
    if (index == array.length ) {
      result.add(sb.toString() ) ;
      return ;
    }
    sb.append( array[index] ) ;
    helper1(index + 1, array, sb, result) ;
    sb.deleteCharAt(sb.length() - 1) ;
    helper1(index + 1, array, sb, result) ;

  }
}
