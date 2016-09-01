public class BinaryTreeMaximumPathSum{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		int rslt = obj.maxPathSum(root);
		System.out.println(rslt);
	}

	public int maxPathSum(TreeNode root){
		int[] max = new int[1]; 
		max[0] = Integer.MIN_VALUE;

		helper(root, max);
		return max[0];
		
	}

	public int helper(TreeNode root, int[] max){
		if(root == null){
			return 0;
		}

		int left = helper(root.left, max);
		int right = helper(root.right, max);

		int threeNodeMax = Math.max(root.val, Math.max(root.val + left, root.val + right));

		max[0] =  Math.max(max[0], Math.max(threeNodeMax, root.val+left+right));
		
		
		return threeNodeMax;
	}
}