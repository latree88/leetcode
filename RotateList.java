public class RotateList{
	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public ListNode rotateRight(ListNode head, int k){
		if(head == null || k == 0){
			return head;
		}

		ListNode tail = head;
		ListNode cur = head;
		int count = 0;
		while(cur != null){
			++count;
			cur = cur.next;

		}

		// if k == n * count then there is no rotation in list
		//  return head immediately
		if(k >= count){
			k = k % count;
		}
		if(k == 0){
			return head;
		}



		for(int i = 0; i < k; i++){
			tail = tail.next;
		}

		cur = head;
		while(tail.next != null){
			cur = cur.next;
			tail = tail.next;
		}

		ListNode newHead = cur.next;
		cur.next = null;
		tail.next = head;

		return newHead;


	}


}





















