package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {
  public static void main(String[] args) {
    ListNode a = new ListNode(1) ;
    ListNode b = new ListNode (2) ;
    System.out.println( a.next == b.next);
//      ListNode L1 = new ListNode(1) ;
//      ListNode L2 = new ListNode(2) ;
//      ListNode L3 = new ListNode(3) ;
//      ListNode L4 = new ListNode(4) ;
//      ListNode L5 = new ListNode(5) ;
//      L1.next = L2 ;
//      L2.next = L3 ;
//      L3.next = L4 ;
//      L4.next = L5 ;
//      ListNode[] arr = new ListNode[1] ;
//      arr[0] = L1;
//      ListNode result = mergeKLists(arr) ;
//      while ( result != null) {
//        System.out.println(result.value) ;
//        result = result.next ;
//      }

    }



  public static ListNode mergeKLists(ListNode[] lists) {
    if ( lists == null) {
      return null ;
    }
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length,
        new Comparator<ListNode>() {
          @Override
          public int compare(ListNode o1, ListNode o2) {

            return o1.value < o2.value ? -1 : 1;
          }
        } ) ;
    ListNode dummy = new ListNode (-1) ;
    ListNode cur = dummy ;
    for ( ListNode head:lists) {
      minHeap.offer(head) ;
    }
    while ( !minHeap.isEmpty() ) {
      ListNode p = minHeap.poll();
      cur.next = p ;
      cur = cur.next ;
      if ( p.next != null) {
        minHeap.offer(p.next ) ;
      }

    }

    return dummy.next ;
  }

}



