package String1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

  public static void main(String [] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(2) ;
    minHeap.offer(2) ;
    minHeap.offer(2) ;
    System.out.println( minHeap.size() ) ;
  }

  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here
    //record the frequency for all words
    // O(n)
    HashMap<String, Integer> map = new HashMap<>() ;
    for (int i = 0 ; i < combo.length; i++) {
      int frequency = map.getOrDefault(combo[i], 0) ;
      frequency++ ;
      map.put( combo[i], frequency) ;
    }
    // find the top k frquency using a min Heap
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(k) ;
    for ( Map.Entry<String, Integer> entry: map.entrySet() ) {
      if ( minHeap.size() < k) {
        minHeap.offer( new Pair(entry.getKey(), entry.getValue() ) ) ;
      } else {
        if ( entry.getValue() > minHeap.peek().frequency ) {
          minHeap.poll() ;
          minHeap.offer( new Pair(entry.getKey(), entry.getValue() ) ) ;
        }
      }
    }
    String[] result = new String[k] ;
    int i = 0;
    while ( !minHeap.isEmpty()  ) {
      result[i] = minHeap.poll().key ;
      i++ ;
    }
    return result;


  }

  static class Pair implements Comparable<Pair> {

    String key;
    Integer frequency ;

    Pair( String key, Integer freq) {
      this.key = key;
      this.frequency = freq;
    }

    @Override
    public int compareTo(Pair p) {
      return  this.frequency < p.frequency ? -1 : 1;
    }


  }
}
