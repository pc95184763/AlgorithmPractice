package DP4;

public class LongestCommonSubString {

  public static void main(String [] ar) {
    System.out.print( longestCommon( "abccddefffghhh","bdhghhf" ) ) ;
  }

  public static String longestCommon(String source, String target) {
    // Write your solution here
    if ( source.length() == 0 || target.length () == 0 ) {
      return new String();
    }

    int ROWS = source.length() + 1;
    int COLS = target.length() + 1;
    int[][] M = new int[ROWS][COLS] ;
    int index = 0;
    int globalMax = 0;
    for (int i = 1 ; i < ROWS; i ++) {
      for (int j = 1 ; j < COLS ; j++) {

        if ( source.charAt(i - 1) == target.charAt(j - 1) ) {
          M[i][j] = M[i - 1][j - 1] + 1 ;
          if ( M[i][j] > globalMax)  {
            globalMax =   M[i][j]  ;
            index = i - 1;
          }

        }

      }
    }

    return source.substring( index - globalMax + 1, index + 1)  ;
  }
}
