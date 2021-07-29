package DFS;
import java.util.* ;

public class ALLSubset {

  public static void  main(String [] args) {
    List<String> result = subSets(new String("abc") ) ;
    for (String i: result){
      System.out.print(i + " ") ;
    }

  }


  public static List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>() ;
    if (set == null) {
      return result ;
    }
    StringBuilder builder = new StringBuilder() ;
    DFS(set, 0 ,builder, result) ;
    return result ;
  }

  private static void DFS (String set, int index, StringBuilder builder, List<String> result ) {
    if ( index == set.length() ) {
      result.add( builder.toString() ) ;
      return ;
    }
    builder.append(set.charAt(index));
    DFS(set, index + 1, builder, result ) ;
    builder.deleteCharAt(builder.length() - 1) ;
    DFS(set, index + 1, builder, result ) ;
  }




}

/*
如何只选第一种情况
                          {a, b, b}
index=0             /                         \
a                {a}                           {}
1             /       \                        /     \
b1          {a,b}  ->  {a}                  {b}      {}
	          / \         |                  /\        /\
b2  {a,b,b} ->{a,b}    {a}            {b,b} {b}    {b}  {}
        |      |        |
      打印
 */
