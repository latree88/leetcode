public class InsertionSortedList{


	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}



	}

	public ListNode insertionSortList(ListNode head){
		if(head == null){
			return head;
		}

		ListNode dummy = new ListNode(-1);

		while(head != null){
			ListNode cur = dummy;

			while(cur.next != null && cur.next.val < head.val){
				cur = cur.next;
			}

			ListNode temp = head.next;
			head.next = cur.next;
			cur.next = head;
			head = temp;
		}


		return dummy.next;



	}

}







































