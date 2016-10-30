public class ConvertBinarySearchTreeToDoublyLinkedList{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public static class DoublyListNode{
		int val;
		DoublyListNode next;
		DoublyListNode prev;

		public DoublyListNode(int val){
			this.val = val;
			this.next = this.prev = null;
		}

	}

	public static class ResultType{
		DoublyListNode first, last;

		public ResultType(DoublyListNode first, DoublyListNode last){
			this.first = first;
			this.last = last; 
		}
	}

	public static void main(String args[]){
		ConvertBinarySearchTreeToDoublyLinkedList obj = new ConvertBinarySearchTreeToDoublyLinkedList();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right =  new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		DoublyListNode head = obj.bstToDoublyList(root);

	}


	public DoublyListNode bstToDoublyList(TreeNode root){
		ResultType rslt = new ResultType(null, null);
		
		helper(root, rslt);
		return rslt.first;

	}


	public void helper(TreeNode root, ResultType rslt){
		if(root == null){
			return;
		}


		helper(root.left, rslt);
		if(rslt.first == null){
			rslt.first = new DoublyListNode(root.val);
			rslt.last = rslt.first;
		}
		else{
			rslt.last.next = new DoublyListNode(root.val);
			rslt.last.next.prev = rslt.last;

			rslt.last = rslt.last.next;
		}

		helper(root.right, rslt);

	}


}





































