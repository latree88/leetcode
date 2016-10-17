public class RemoveLinkedListElements{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public ListNode removeElements(ListNode head, int val){
		if(head == null){
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode cur = dummy;
		while(cur.next != null){
			if(cur.next.val == val){
				cur.next = cur.next.next;
			}
			else{
				cur = cur.next;

			}
		}

		return dummy.next;

	}


}

































