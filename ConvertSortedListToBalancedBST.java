public class ConvertSortedListToBalancedBST{
	public static class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}


	public static class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){

	}

	private ListNode cur;

	public TreeNode sortedListToBST(ListNode head){
		int size = findSize(head);
		cur = head;
		return sortedListToBSTHelper(size);

	}

	public int findSize(ListNode head){
		int count = 0;
		while(head != null){
			head = head.next;
			++count;
		}
		return count;
	}



	public TreeNode sortedListToBSTHelper(int size){
		if(size <= 0){
			return null;
		}

		TreeNode left = sortedListToBSTHelper(size/2);

	
		TreeNode root = new TreeNode(cur.val);
		cur = cur.next;
		TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

		root.left = left;
		root.right = right;

		return root;
	}
}