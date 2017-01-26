public class FlattenBinaryTreeToLinkedList{

	public class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public void flatten(TreeNode root){
		helper(root);

	}

	public TreeNode helper(TreeNode root){

		if(root == null){
			return null;
		}

		TreeNode leftLast = helper(root.left);
		TreeNode rightLast = helper(root.right);

		if(leftLast != null){
			leftLast.right =  root.right;
			root.right = root.left;
			root.left = null;
		}

		if(rightLast != null){
			return rightLast;
		}

		if(leftLast != null){
			return leftLast;
		}

		return root;
	}

}


























