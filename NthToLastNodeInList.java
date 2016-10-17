public class NthToLastNodeInList{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public ListNode nthToLast(ListNode head, int n){
		if(head == null){
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;

		for(int i = 0; i < n - 1; i++){
			if(fast == null){
				return null;
			}
			fast = fast.next;
		}


		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}


}




































