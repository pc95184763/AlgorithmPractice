package DP;

import java.util.*;

public class Diction {


  public static void main(String [] args) {
    String s = "abcdefg" ;
    System.out.println( s.substring(4,5) );
  }


  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    //M[i]: if the first i letters can be composed by dict
    //dict : {bob, cat, rob}
    // example: "bob"
    // "b"
    // "bo"  case1  no cut    false
    //       case2  "b|o"       M[1] = false && "o" can NOT find in dict, so its false

    // "bob" case1 no cut     true
    //       "b|ob"           M[1] =false
    //       "bo|b"           M[2] = false       M[3] = true;

    // "bobc" case1 no cut    false
    //        case2 "b|obc"   M[1] = false && "obc"     --> false
    //        case3 "bo|bc"   M[2] = false && "bc"  --> false
    //        case4 "bob|c"   M[3] = true && "c"  -- > false

    // "bocatrob"

    Set<String> dictSet = toSet(dict) ;
    boolean [] M = new boolean[input.length() + 1 ] ;
    M[0] = true ;
    for (int i = 1; i <= input.length() ;i++) {
      boolean cur = false ;
      for (int j = 0; j < i; j ++) {
        cur = cur || (M[j] && dictSet.contains( input.substring(j, i) ) ) ;
      }
      M[i] = cur ;
    }
    return M[M.length - 1] ;

  }

  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>() ;
    for (String s: dict) {
      set.add(s);
    }
    return set ;
  }




}
