package DFS;
import java.util.* ;

public class AllPermutation {

  public static void main(String[] arg) {

    List<String> result = permutations(new String("") ) ;
    for (String i: result){
      System.out.print(i + " ") ;
    }
  }

  public static List<String> permutations(String input) {
    // Write your solution here
    List<String> result = new ArrayList<>() ;
    if (input.length() == 0) {
      return result;
    }
    char[] array = input.toCharArray() ;
    helper(0, array, result) ;

    return result;

  }

  private static void helper(int index, char[] array, List<String> result) {
    if (index == array.length - 1 ) {
      result.add(new String(array) ) ;
    }
    for (int i = index; i < array.length; i++) {
      swap(array, index ,i) ;
      helper(index + 1, array, result) ;
      swap(array, index ,i) ;
    }
  }

  private static void swap(char[] array, int i, int j) {
    char temp = array[i] ;
    array[i] = array[j] ;
    array[j] = temp;
  }
}
