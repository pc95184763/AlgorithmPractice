package CrossTrainning2;

import java.util.*;

public class DeepCopyLinkedList {



  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if (head == null) {
      return null ;
    }
    Map<RandomListNode, RandomListNode> lookup = new HashMap<>() ;
    RandomListNode newHead = new RandomListNode(head.value) ;
    lookup.put(head, newHead)  ;
    RandomListNode cur = newHead ;
    while ( head != null) {
      if (head.next != null) {
        if ( !lookup.containsKey(head.next )) {
          lookup.put(head.next, new RandomListNode(head.next.value) ) ;
        }
        cur.next= lookup.get(head.next) ;
      }
      if (head.random != null) {
        if ( !lookup.containsKey(head.random) ) {
          lookup.put(head.random, new RandomListNode(head.random.value) ) ;
        }
        cur.random = lookup.get(head.random) ;
      }
      head = head.next;
      cur = cur.next ;
    }
    return newHead ;

  }
}


class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
}
