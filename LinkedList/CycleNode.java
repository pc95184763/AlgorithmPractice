package LinkedList;

public class CycleNode {

  public static void main(String[] args) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy ;
    int[] arr = new int[] {12, 2, 6, 9, 3, 1, 22, 5, 222, -1, 33, 66, 110} ;
    ListNode fifth = null ;
    for (int i = 0 ; i < arr.length ; i++) {
      cur.next = new ListNode( arr[i] ) ;
      cur = cur.next ;
      if ( i == 5) {
        fifth = cur ;
      }
    }
    cur.next = fifth ;

    System.out.println( cycleNode(dummy.next).value ) ;
  }

  public static ListNode cycleNode(ListNode head) {
    // write your solution here
    if ( head == null || head.next == null ) {
      return null;
    }
    ListNode fast = head ;
    ListNode slow = head ;
    while ( fast != null && fast.next != null ) {
      slow = slow.next ;
      fast = fast.next.next ;
      if ( fast == slow ) {
        while ( head != fast) {
          fast = fast.next ;
          head = head.next ;
        }
        return head ;
      }
    }
    return null ;
  }
}
