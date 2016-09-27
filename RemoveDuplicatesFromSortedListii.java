public class RemoveDuplicatesFromSortedListii{
	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);

		ListNode rslt = new RemoveDuplicatesFromSortedListii().deleteDuplicates(head);

		while(rslt != null){
			System.out.println(rslt.val);
			rslt = rslt.next;
		}




	}

	public static ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode preDelete = dummy;
		preDelete.next = head;

		while(head.next != null){
			if(preDelete.next.val == head.next.val){
				head = head.next;
				while(head != null && preDelete.next.val == head.val){
					head = head.next;
				}
				preDelete.next = head;
				if(head == null){
					break;
				}
			}
			else{
				preDelete = preDelete.next;
				head = head.next;
				if(head == null){
					break;
				}
			}

		}

		return dummy.next;
	}
}