public class CompleteBinaryTree{


	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;


		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public class ResultType{
		int depth;
		boolean isFull;
		boolean isComplete;

		public ResultType(int depth, boolean isFull, boolean isComplete){
			this.depth = depth;
			this.isFull = isFull;
			this.isComplete = isComplete;
		}
	}

	public boolean isComplete(TreeNode root){
		ResultType rslt = check(root);

		return rslt.isComplete;

	}


	public ResultType check(TreeNode root){
		if(root == null){
			return new ResultType(0, true, true);
		}

		ResultType left = check(root.left);
		ResultType right = check(root.right);

		if(!left.isComplete){
			return new ResultType(-1, false, false);
		}


		if(left.depth == right.depth){
			if(!left.isFull || !right.isComplete){
				return new ResultType(-1, false, false);
			}
			return new ResultType(left.depth + 1, right.isFull, true);
		}

		if(left.depth == right.depth + 1){
			if(!left.isComplete || !right.isFull){
				return new ResultType(-1, false, false);
			}

			return new ResultType(left.depth + 1, false, true);
		}

		return new ResultType(-1, false, false);



	}
}




























