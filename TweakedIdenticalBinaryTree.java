public class TweakedIdenticalBinaryTree{

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public boolean isTweakedIdentical(TreeNode a, TreeNode b){
		if(a == null && b == null){
			return true;
		}
		
		if(a == null || b == null){
			return false;
		}


		if(a.val != b.val){
			return false;
		}

		if(isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)){
			return true;
		}
		
		if(isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)){
			return true;
		}

		return false;



	}

}




















