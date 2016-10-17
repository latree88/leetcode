public class MiddleOfLinkedList{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}

	}

	public static void main(String arg[]){

	}


	public ListNode middleNode(ListNode head){

		if(head == null || head.next == null){
			return head;
		}


		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}


}