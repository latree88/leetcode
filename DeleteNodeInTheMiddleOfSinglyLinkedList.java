public class DeleteNodeInTheMiddleOfSinglyLinkedList{


	public class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public void deleteNode(ListNode node){
		if(node == null || node.next == null){
			return;
		}

		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		return;

	}

}