package CrossTraining3;

import java.util.*;

public class MergeKListNode {
  public ListNode merge(List<ListNode> listOfLists) {
    // Write your solution here/.
    ListNode dummy = new ListNode (-1) ;
    ListNode cur = dummy ;

    PriorityQueue<ListNode> pq = new PriorityQueue( 11 ,new MyComparator() ) ;
    for ( ListNode head : listOfLists ) {
      if (head != null ) {
        pq.add(head) ;
      }
    }
    while( !pq.isEmpty()) {
      ListNode p = pq.poll() ;
      cur.next = p;
      cur = cur.next ;
      if (p.next != null) {
        pq.add(p.next) ;
      }
    }


    return dummy.next;
  }

  static class MyComparator implements Comparator<ListNode> {
    public int compare(ListNode n1, ListNode n2) {
      if (n1.value == n2.value) {
        return 0;
      }
      return n1.value < n2.value? -1 : 1;
    }
  }
}



class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}
