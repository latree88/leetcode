public class AddTwoNumbers{

	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public ListNode addLists(ListNode l1, ListNode l2){
		
		if(l1 == null && l2 == null){
			return null;
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;
		int carry = 0;

		while(l1 != null && l2 != null){
			int sum = carry + l1.val + l2.val;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;

			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}


		while(l1 != null){
			int sum = carry + l1.val;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;

			l1 = l1.next;
			cur = cur.next;
		}


		while(l2 != null){
			int sum = carry + l2.val;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;

			l2 = l2.next;
			cur = cur.next;
		}

		if(carry !=  0){
			cur.next = new ListNode(carry);
		}

		return head.next;
	}




}
















































