public class BinaryTreeLongestConsecutiveSequence{


	public class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}

	}

	private int longest;

	public int longestConsecutive(TreeNode root){
		longest = 0;
		helper(root);

		return longest;
	}


	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		int subtreeLongest = 1;

		if(root.left != null && root.val + 1 == root.left.val){
			subtreeLongest = Math.max(subtreeLongest, left + 1);
		}

		if(root.right != null && root.val + 1 == root.right.val){
			subtreeLongest = Math.max(subtreeLongest, right + 1);
		}

		if(subtreeLongest > longest){
			longest = subtreeLongest;
		}

		return subtreeLongest;

	}
}
















