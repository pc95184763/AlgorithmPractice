package LinkedList;

public class ReOrderLinkedList {

  public static void main(String [] args) {

    int[] arr = new int[] {293,16,11} ;
    ListNode head = new ListNode(-1) ;
    ListNode cur = head ;

    for (int i = 0 ; i < arr.length ; i ++) {
      cur.next = new ListNode(arr[i]) ;
      cur = cur.next ;
    }
    head = reorder(head.next) ;

    while (head != null) {
      System.out.print(head.value+" ");
      head = head.next ;
    }

  }


  public static ListNode reorder(ListNode head) {
    // Write your solution here
    if ( head == null || head.next == null) {
      return head;
    }
    ListNode lastOfFirstHalf = findMid(head) ;
    ListNode headerOfSecond = lastOfFirstHalf.next ;
    lastOfFirstHalf.next = null ;
    headerOfSecond = reverse(headerOfSecond) ;


    ListNode dummy = new ListNode(-1) ;
    ListNode cur = dummy;
    while ( head != null && headerOfSecond != null) {
      cur.next = head;
      head = head.next ;
      cur = cur.next ;
      cur.next = headerOfSecond ;
      headerOfSecond = headerOfSecond.next ;
      cur = cur.next ;
    }
    if (head != null) {
      cur.next = head ;
    }
    return dummy.next ;
  }
  public static ListNode findMid(ListNode head) {
    ListNode slow = head ;
    ListNode fast = head ;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next ;
      fast = fast.next.next ;
    }
    return slow ;
  }

  public static ListNode reverse (ListNode head) {
    ListNode pre = null ;
    while ( head != null) {
      ListNode nxt = head.next ;
      head.next = pre;
      pre = head ;
      head = nxt ;
    }
    return pre ;
  }
}
