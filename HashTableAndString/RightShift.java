package HashTableAndString;

public class RightShift {

  public static void main(String [] args) {
    String a = "" ;
    a = rightShift(a, 10) ;
    System.out.println(a);
  }

  public static String rightShift(String input, int n) {
    // Write your solution here

    n = n % input.length() ;

    char[] array =input.toCharArray() ;
    reverse(array, 0, array.length - 1) ;
    reverse(array, 0, n -1) ;
    reverse(array, n, array.length - 1) ;

    return new String(array) ;
  }
  public static void reverse(char[] array, int left, int right) {
    while (left < right) {
      char temp = array[left] ;
      array[left] = array[right] ;
      array[right] = temp;
      left++;
      right--;
    }
  }
}
