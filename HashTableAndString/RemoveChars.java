package HashTableAndString;

import java.util.*;

public class RemoveChars {

  public static void main(String[] args) {
    String input = new String("stuudennnt") ;
    String target = "un" ;
    String out = remove(input, target) ;
    System.out.println(out);
  }


  public static String remove(String input, String t) {
    // Write your solution here
    char[] arr = input.toCharArray() ;

    Set<Character> set = getSetFromString(t) ;

    int slow = 0;

    for (int fast = 0; fast < arr.length ; fast ++) {
      if ( !set.contains(arr[fast]) ) {
        arr[slow++] = arr[fast] ;
      }
    }

    return new String(arr, 0 , slow)  ;
  }

  public static Set getSetFromString(String t) {
    Set set = new HashSet<Character>();
    for (int i = 0; i < t.length() ; i ++) {
      set.add(t.charAt(i)) ;
    }
    return set ;
  }

}
