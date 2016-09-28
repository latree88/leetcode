public class LinkedListCycleii{
	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]){

	}

	// Set the starting point when fast meet slow
	// then move the head as the same speed 
	// that slow move to the cycle tail
	// then head is starting point of cycle.
	// ????????????????????????????????????????? 
	public ListNode detectCycle(ListNode head){
		if(head == null || head.next == null){
			return null;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while(slow != fast){

			if(fast == null || fast.next == null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		while(head != slow.next){
			head = head.next;
			slow = slow.next;
		}

		return head;
	}
}