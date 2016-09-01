public class BalancedBinaryTree{

	public static class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		BalancedBinaryTree obj = new BalancedBinaryTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		

		boolean rslt = obj.isBalanced(root);
		System.out.println(rslt);
	}

	public static boolean isBalanced(TreeNode root){
		return maxDepth(root) != -1;
	}

	public static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		if(leftMax == -1 || rightMax == -1 || Math.abs(leftMax - rightMax) > 1){
			return -1;
		}
		return Math.max(leftMax, rightMax) + 1;
	}
}