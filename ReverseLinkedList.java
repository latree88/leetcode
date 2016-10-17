public class ReverseLinkedList{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public ListNode reverse(ListNode head){
		ListNode pre = null;
		while(head != null){
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}	

		return pre;

	}
}















