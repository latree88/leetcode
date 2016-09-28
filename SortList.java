public class SortList{
	public static class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]){

	}

	public ListNode sortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		ListNode mid = findMid(head);

		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);

		return mergeSort(left, right);

	}


	public ListNode findMid(ListNode head){
		ListNode slow = head;
		ListNode fast  = head.next;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public ListNode mergeSort(ListNode left, ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while(left != null && right != null){
			if(left.val < right.val){
				tail.next = left;
				left = left.next;
			}
			else{
				tail.next = right;
				right = right.next;
			}

			tail = tail.next;
		}

		if(left != null){
			tail.next = left;
		}
		else{
			tail.next = right;
		}

		return dummy.next;

	}





}