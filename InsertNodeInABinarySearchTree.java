public class InsertNodeInABinarySearchTree{



	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public TreeNode insertNode(TreeNode root, TreeNode node){
		if(root == null){
			return node;
		}

		if(root.val > node.val){
			root.left = insertNode(root.left, node);
		}
		else{
			root.right = insertNode(root.right, node);
		}

		return root;


	}
}




































