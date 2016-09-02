public class LowestCommonAncestor{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		LowestCommonAncestor obj = new LowestCommonAncestor();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		TreeNode rslt = obj.lowestCommonAncestor(root, root.left, root.right.left);

		System.out.println(rslt.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
		if(root == null || root == A || root == B){
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);

		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}

		return null;
	}	
}