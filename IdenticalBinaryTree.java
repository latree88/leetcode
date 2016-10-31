public class IdenticalBinaryTree{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public boolean isIdentical(TreeNode a, TreeNode b){

		if(a == null && b == null){
			return true;

		}
		if(a != null && b != null){
			return a.val == b.val &&
				   isIdentical(a.left, b.left) &&
				   isIdentical(a.right, b.right);
		}
		return false;


	}

}


































