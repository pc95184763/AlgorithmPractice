package MyTest;
import java.util.*;


public class DFSDecode {


  public List<String> decode(String input) {
    List<String> result = new ArrayList<>() ;

    StringBuilder buf = new StringBuilder() ;
    DFS(input, 0 , result) ;

    return result ;
  }

  private void DFS (String input, int index, List<String> result) {


  }

}



