


public class RemoveDuplicatesFromSortedList{


	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public static ListNode deleteDuplicates(ListNode head){
		if(head == null){
			return head;
		}

		ListNode cur = head;
		while(cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}
			else{
				cur = cur.next;
			}
		}

		return head;
	}


}





































