public class SwapTwoNodesInLinkedList{

	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public ListNode swapNodes(ListNode head, int v1, int v2){
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		if(head == null){
			return head;
		} 

		ListNode preV1 = null;
		ListNode preV2 = null;

		ListNode cur = dummy;
		while(cur.next != null){
			if(cur.next.val == v1){
				preV1 = cur;
			}
			if(cur.next.val == v2){
				preV2 = cur;
			}

			cur = cur.next;
		}

		if(preV1 == null || preV2 == null){
			return dummy.next;
		}

		if(preV2.next == preV1){
			ListNode temp = preV1;
			preV1 = preV2;
			preV2 = temp;
		}



		ListNode node1 = preV1.next;
		ListNode node2 = preV2.next;
		ListNode node2Next = node2.next;

		if(preV1.next == preV2){
			node1.next = node2.next;
			preV1.next = node2;
			node2.next = node1;
		}
		else{
            preV1.next = node2;
            node2.next = node1.next;
            
            preV2.next = node1;
            node1.next = node2Next;
		}


		return dummy.next;

	}


}



























