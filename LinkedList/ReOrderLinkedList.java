package LinkedList;

public class ReOrderLinkedList {

  public static void main(String [] args) {

    int[] arr = new int[] {293,16,83,960,430,215,369,813,343,927,480,263,797,885,408,146,895,677,994,673,116,1015,330,714,954,910,339,822,903} ;
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
    if (head == null || head.next == null) {
      return head ;
    }
    ListNode mid = findMid(head) ;
    ListNode right = mid.next ;
    mid.next = null ;
    ListNode left = head ;
    right = reverse(right) ;

    ListNode dummy = new ListNode (-1) ;
    ListNode curDummy =  dummy ;

    while (left != null && right != null) {
      curDummy.next = left ;
      left = left.next ;
      curDummy.next.next = right ;
      right = right.next ;
      curDummy = curDummy.next.next ;
    }
    if ( left != null) {
      curDummy.next = left ;
    } else {
      curDummy.next = right ;
    }
    return dummy.next ;
  }

  private static ListNode findMid(ListNode head) {
    if ( head == null || head.next == null ) {
      return head ;
    }
    ListNode fast = head ;
    ListNode slow = head ;
    while ( fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next ;
      fast = fast.next.next ;
    }
    return slow ;
  }

  private static ListNode reverse (ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null ;
    while (head != null ) {
      ListNode nxt = head.next ;
      head.next = pre ;
      pre = head ;
      head = nxt ;
    }
    return pre ;
  }
}
