public class PartitionList{
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
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode rslt = new PartitionList().partition(head, 3);

		while(rslt != null){
			System.out.println(rslt.val);
			rslt = rslt.next;
		}

	}

	public ListNode partition(ListNode head, int x){
		if(head == null){
			return null;
		}

		ListNode leftList = new ListNode(0);
		ListNode rightList = new ListNode(0);

		ListNode left = leftList;
		ListNode right = rightList;

		while(head != null){
			if(head.val < x){
				left.next = head;
				left = head;
			}
			else{
				right.next = head;
				right = head;
			}
			head = head.next;
		}

		right.next = null;
		left.next = rightList.next;

		return leftList.next;
	}
}