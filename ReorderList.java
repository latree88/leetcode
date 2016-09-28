public class ReorderList{
	public static class ListNode{
		int val;
		ListNode next;
	
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]){
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);

		ListNode rslt = new ReorderList().reorderList(head);

		while(rslt != null){
			System.out.println(rslt.val);
			rslt = rslt.next;
		}

	}

	public ListNode reorderList(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		if(head == null || head.next == null || head.next.next == null){
			return dummy.next;
		}



		ListNode pre = dummy.next;
		ListNode cur = dummy.next.next;

		while(cur.next != null){
			ListNode temp = cur.next;
			if(temp.next == null){
				pre.next = temp;
				temp.next = cur;
				cur.next = null;
				
				break;
			}
			else{
				while(temp.next.next != null){
					temp = temp.next;
				}
				pre.next = temp.next;
				temp.next.next = cur;
				temp.next = null;
			}

			pre = cur;
			cur = cur.next;

		}

		return dummy.next;
	}

}