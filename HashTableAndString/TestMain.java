package HashTableAndString;

public class TestMain {

  public static void main(String[] args) {
//    String input= "laicode";
//    String source ="code" ;
//    String target = "offer" ;
//    String out = replace(input, source, target) ;
//    System.out.println(out);

    short a = -1;
    char b = (char) a ;
    int c = (int) b ;
    System.out.println(c);

  }


  public static String replace(String input, String source, String target) {
    // Write your solution here
    if (source.length() >= target.length() ){
      return longToShortReplace(input, source, target) ;
    }
    else {
      return shortToLongReplace(input, source, target) ;
    }
  }
  public  static String longToShortReplace(String input, String source, String target) {
    int slow = 0;
    int fast = 0;
    char[] array = input.toCharArray() ;

    while ( fast <= array.length - source.length() ) {
      if ( equals(array, fast, source)) {
        copy(array, slow, target) ;
        fast += source.length() ;
        slow += target.length() ;
        continue ;
      }
      array[slow++] = array[fast ++];
    }
    return new String(array, 0, slow) ;
  }

  public static boolean equals ( char[] input, int start, String source) {
    for (int i = 0 ; i < source.length() ; i ++) {
      if (input[start + i] != source.charAt(i) ) {
        return false;
      }
    }
    return true;
  }

  public static boolean equalsReverse ( char[] input, int start, String source ) {
    for (int i = 0 ; i < source.length() ; i ++) {
      if (input[start - i] != source.charAt(source.length() - 1 - i) ) {
        return false;
      }
    }
    return true;
  }


  public  static void copy (char[] array, int start, String source) {
    for (int i = 0 ; i < source.length() ; i ++ ) {
      array[start + i] = source.charAt(i) ;
    }
  }
  public static void copyReverse (char[] array, int start, String source) {
    int count = source.length() ;
    while ( count > 0) {
      array[start--] = source.charAt(count -1) ;
      count -- ;
    }
  }

  public static String shortToLongReplace(String input, String source, String target) {
    int diff = target.length() - source.length() ;
    int count = 0 ;
    char[] array = input.toCharArray() ;

    for ( int i = array.length -  1 ; i >= 0 ; i --) {
      if (equalsReverse(array, i, source) ){
        count++ ;
      }
    }


    char[] resultArr = new char[ array.length + count * diff] ;

    int fast = array.length - 1;
    int slow = resultArr.length - 1;

    while ( fast >= source.length() - 1) {
      if ( equalsReverse(array, fast, source)) {
        copyReverse(resultArr, fast, target) ;
        fast -= source.length() ;
        slow -= target.length() ;
        continue ;
      }
      resultArr[slow--] = array[fast --];
    }
    return new String(resultArr) ;

  }
}
