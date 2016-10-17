public class SwapNodesInPairs{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public ListNode swapPairs(ListNode head){
		if(head == null){
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode cur = dummy;
		while(cur.next != null && cur.next.next != null){
			ListNode n1 = cur.next;
			ListNode n2 = cur.next.next;

			cur.next = n2;
			n1.next = n2.next;
			n2.next = n1;

			cur = n1;
		}

		return dummy.next;

	}
}























