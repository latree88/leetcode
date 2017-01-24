public class SubtreeWithMaximumAverage{

	public class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			left = right = null;
		} 
	}

	private class ResultType{
		int sum, size;

		public ResultType(int sum, int size){
			this.sum = sum;
			this.size = size;
		} 

	}

	private TreeNode subtree = null;
	private ResultType subtreeResult = null;


	public TreeNode findSubtree2(TreeNode root){
		helper(root);

		return subtree;
	}


	public ResultType helper(TreeNode root){
		if(root == null){
			return new ResultType(0, 0);
		}


		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		ResultType res = new ResultType(left.sum + right.sum + root.val, 
										left.size + right.size + 1);


		if(subtree == null || subtreeResult.sum * res.size < res.sum * subtreeResult.size){
			subtree = root;
			subtreeResult = res;
		}

		return res;




	}



}

















