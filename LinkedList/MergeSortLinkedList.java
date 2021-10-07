package LinkedList;

public class MergeSortLinkedList {

  public static void main(String[] args) {
      ListNode p1 = new ListNode(5) ;
    ListNode p2 = new ListNode(3) ;
    ListNode p3 = new ListNode(2) ;
    p1.next = p2 ;
    p2.next = p3 ;

    p1 = mergeSort(p1) ;
    while ( p1 != null ) {
      System.out.println(p1.value);
      p1 = p1.next ;
    }
  }


  public static ListNode mergeSort(ListNode head) {
    // Write your solution here
    // base case
    if ( head == null || head.next == null) {
      return head ;
    }

    ListNode mid = findMid(head) ;
    ListNode right = mid.next ;
    mid.next = null ;
    head = mergeSort( head ) ;
    right = mergeSort( right ) ;
    return merge(head, right) ;

  }
  public static ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
      return head ;
    }
    ListNode slow = head ;
    ListNode fast = head ;
    while (fast != null && fast.next != null && fast.next.next != null) {
      fast = fast.next.next ;
      slow = slow.next ;
    }
    return slow ;
  }

  public static ListNode merge(ListNode left, ListNode right ) {

    ListNode p = new ListNode (-1) ;
    ListNode cur = p ;
    while ( left != null && right != null ) {
      if (left.value < right.value) {
        cur.next = left ;
        left = left.next ;
      } else {
        cur.next = right ;
        right = right.next ;
      }
      cur = cur.next ;
    }
    if (left == null) {
      cur.next = right ;
    } else {
      cur.next = left ;
    }

    return p.next ;
  }
}
