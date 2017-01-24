public class MinimumSubtree{


	public class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	private TreeNode subtree = null;
	private int subtreeSum = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root){
		helper(root);
		return subtree;
	}

	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}


		int sum = helper(root.left) + helper(root.right) + root.val;
		if(sum < subtreeSum){
			subtree = root;
			subtreeSum = sum;
		}

		return sum;
	}
}



















