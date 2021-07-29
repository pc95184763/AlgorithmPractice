package CrossTraining3;

import java.util.*;

public class CommonElementsInKList {


  public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(input.size(), new Comparator<Entry>(){
      public int compare(Entry e1, Entry e2) {
        if(e1.value == e2.value) {
          return 0;
        }
        return e1.value < e2.value ? -1 : 1 ;
      }
    }) ;

    int max = 0 ;
    for (int i = 0 ; i < input.size() ; i++) {
      List<Integer> cur = input.get(i) ;
      minHeap.offer(new Entry(i, 0, cur.get(0) )) ;
      max = Math.max(max, cur.get(0) ) ;
    }
    while (!minHeap.isEmpty()) {
      if (minHeap.peek().value == max)  {
        result.add(max) ;
        while ( !minHeap.isEmpty()) {
          Entry e = minHeap.poll() ;
        }
      }
    }


    return result ;
  }

  private static class Entry {
    int indexOfArray;
    int indexInArray;
    int value ;

    Entry (int indexOfArray, int indexInArray, int value) {
      this.indexOfArray = indexOfArray ;
      this.indexInArray = indexInArray ;
      this.value = value ;
    }
  }
}
