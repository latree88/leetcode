public class ReverseNodesInKGroup{

	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}

	}


	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null){
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		head = dummy;

		while(head.next != null){
			head = reverseNextK(head, k);
		}

		return dummy.next;

	}

	//reverse head->n1...-> nk ->temp
	// to head -> nk ... -> n1 -> temp
	// return n1


	public ListNode reverseNextK(ListNode head, int k){
		// check if there is enough nodes to reverse
		ListNode next = head;
		for(int i = 0; i < k; i++){
			if(next.next == null){
				return next;
			}
			
			next = next.next;
			
		}

		// start to reverse
		// sooooooo complicated !!!!!!!!!!!!!!!!!!!
		ListNode n1 = head.next;
		ListNode cur = n1;
		ListNode pre = head;
		for(int i = 0; i < k; i++){
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}

		n1.next = cur;
		head.next = pre;

		return n1;

	}
}





















