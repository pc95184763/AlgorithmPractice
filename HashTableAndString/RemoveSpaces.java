package HashTableAndString;

public class RemoveSpaces {

  public static void main(String[] args ) {
    String s = " Hello World  tansen  _ daibi   " ;
    s = removeSpaces(s) ;
    System.out.println(s);
  }



  public static String removeSpaces(String input) {
    if ( input.isEmpty() ) {
      return input;
    }



    char[] arr = input.toCharArray() ;
    int slow = 0;
    for (int i = 0 ; i < arr.length ; i ++ ) {
      if (arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ' )  ) {
        continue ;
      }
      arr[slow++] = arr[i] ;
    }

    if (slow > 0 && arr[slow - 1] == ' ' ){
      slow -- ;
    }
    return new String(arr, 0 , slow) ;
  }

}
