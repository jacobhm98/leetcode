import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
       Set<ListNode> visitList = new HashSet<>();
       while (head != null){
	       if (visitList.contains(head)) {
		       //we have been here before, there is a cycle
		       return head;
	       }

	       visitList.add(head);
	       head = head.next;
       }
       return null;
    }
}
