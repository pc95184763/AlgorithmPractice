package LinkedList;

public class CycleNodeInLinkedList {

  public static void main(String[] args) {

      int[] arr = new int[] {12, 2, 6, 9, 3, 1, 22, 5, 222, -1, 33, 66} ;

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
      if ( slow == fast ) {
        return fast ;
      }
    }
    return null ;
  }
}
