public class BinaryTreeMaximumPathSumii{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}

	}
	public static void main(String args[]){
		BinaryTreeMaximumPathSumii obj = new BinaryTreeMaximumPathSumii();
		TreeNode root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		root.right = new TreeNode(-7);

		int rslt = obj.maxPathSum2(root);
		System.out.println(rslt);

	}

	public int maxPathSum2(TreeNode root){
		int max = Integer.MIN_VALUE;
		
		return helper(root, max);

	}

	public int helper(TreeNode root, int max){
		if(root == null){
			return 0;
		}

		int left = helper(root.left, max);
		int right = helper(root.right, max);


		// *************
		// be carefule with the case that subtree 
		// path sum can be negative
		return Math.max(root.val, Math.max(left + root.val, right + root.val));
	}
}