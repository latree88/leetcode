public class ReverseLinkedListii{
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
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode rslt = new ReverseLinkedListii().reverseBetween(head, 1, 4);

		while(rslt != null){
			System.out.println(rslt.val);
			rslt = rslt.next;
		}

	}

	public ListNode reverseBetween(ListNode head, int m, int n){
		ListNode leftTail;
		ListNode rightHead;

		ListNode toReverseTail;
		ListNode toReverseHead;  

		
		if(m == 1){
			leftTail = null;
			toReverseHead = head;

		}
		else{
			leftTail = findNode(head, m - 2);
			toReverseHead = leftTail.next;  
		}
		
		toReverseTail = findNode(head, n - 1);
		rightHead = toReverseTail.next;


		// System.out.println("toReverseHead: " + toReverseHead.val);
		// System.out.println("toReverseTail: " + toReverseTail.val);

		// System.out.println("leftTail: " + leftTail.val);
		// System.out.println("rightHead: " + rightHead.val);



		ListNode reversedHead = reverse(toReverseHead, toReverseTail);

		ListNode dummy = new ListNode(0);
		dummy.next = reversedHead;

		while(reversedHead.next != null){
			reversedHead = reversedHead.next;
		}

		if(leftTail == null){
			head = dummy.next;
		}
		else{
			leftTail.next = dummy.next;
		}
		reversedHead.next = rightHead;

		return head; 
	}



	public ListNode findNode(ListNode head,int pos){
		if(pos < 0){
			return head;
		}

		for(int i = 0; i < pos; i++){
			if(head == null){
				return null;
			}
			head = head.next;
		}

		return head;

	}

	public ListNode reverse(ListNode head, ListNode tail){
		ListNode dummy = new ListNode(0);
		ListNode cur = head;

		while(cur != tail.next){
			ListNode temp = dummy.next;
			dummy.next = new ListNode(cur.val);
			dummy.next.next = temp;

			cur = cur.next;
		}

		return dummy.next;
	}

















}