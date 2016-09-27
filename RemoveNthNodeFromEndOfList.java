public class RemoveNthNodeFromEndOfList{

	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int value){
			this.val = value;
			this.next = null;
		}
	}


	public static void main(String arg[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		// head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);

		ListNode rslt = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);


		ListNode cur = rslt;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}



	}


	public ListNode removeNthFromEnd(ListNode head, int n){
		if(n <= 0){
			return null;
		}
	

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode preDelete = dummy;
		for(int i = 0; i < n; i ++){
			if(head == null){
				return null;
			}

			head = head.next;
		} 

		while(head != null){
			preDelete = preDelete.next;
			head = head.next;
		}

		preDelete.next = preDelete.next.next;

		return dummy.next;

	}
}