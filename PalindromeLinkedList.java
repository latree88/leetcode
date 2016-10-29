public class PalindromeLinkedList{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}



	public boolean isPalindrome(ListNode head){
		if(head == null){
			return true;
		}

		ListNode mid = findMiddle(head);

		ListNode secondHalfList = reverse(mid.next);

		ListNode temp1 = head;
		ListNode temp2 = secondHalfList;

		while(temp1 != null && temp2 != null){
			if(temp1.val != temp2.val){
				return false;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if(temp2 == null){
			return true;
		}
		return false;
	}



	public ListNode findMiddle(ListNode head){
		if(head == null){
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


	public ListNode reverse(ListNode head){
		ListNode dummy = null;

		while(head != null){
			ListNode temp = head.next;
			head.next = dummy;
			dummy = head;
			head = temp;
		}

		return dummy;

	}
}


































