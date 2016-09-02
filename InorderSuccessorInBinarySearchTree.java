public class InorderSuccessorInBinarySearchTree{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		InorderSuccessorInBinarySearchTree obj = new InorderSuccessorInBinarySearchTree();
		TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		root.right = new TreeNode(2);
	
		TreeNode rslt = obj.inorderSuccessor(root, root.right);

		if(rslt == null){
			System.out.println("null");
		}
		else{
			System.out.println(rslt.val);
		}
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){

		TreeNode successor = null;

		while(root != null && root != p){
			if(root.val > p.val){
				successor = root;
				root = root.left;
			}
			else{
				root = root.right;
			}
		}

		if(root == null){
			return null;
		}

		if(root.right == null){
			return successor;
		}

		root = root.right;
		while(root.left != null){
			root = root.left;
		}

		return root;

	}


}