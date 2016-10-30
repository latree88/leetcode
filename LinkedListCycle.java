public class LinkedListCycle{

	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}

	}


	public boolean hasCycle(ListNode head){
		if(head == null){
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null && fast.next != null){
			if(fast == slow){
				return true;
			}
			else{
				slow = slow.next;
				fast = fast.next.next;
			}
		}

		return false;

	}
}
























