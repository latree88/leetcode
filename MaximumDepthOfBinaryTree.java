
// be carefull of TreeNode class declaration
//  it has to be static
// static method and variable is created when the class being loaded
// if it is not static, the method and variable(class) is not created when class and main method loaded.
//  is it is not static, the class is created by using new.

public class MaximumDepthOfBinaryTree{
	public static class TreeNode{
		public TreeNode left, right;
		public int val;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;

		}
	}
	

	public static void main(String args[]){
		MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(6);

		int rslt = maxDepth(root);
		System.out.println(rslt);
	}

	public static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}

	
	
}