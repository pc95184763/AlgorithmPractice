package MyTest;

public class Test {

  public static void main(String[] args) {

    char[] input = "1121".toCharArray() ;


    int i = Integer.valueOf( new String(input, 3, 1) ) ;
    System.out.println( (char)('A'+ i - 1)  );
  }
}
