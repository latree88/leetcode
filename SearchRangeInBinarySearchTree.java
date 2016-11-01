import java.util.ArrayList;

public class SearchRangeInBinarySearchTree{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


 	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2){
 		ArrayList<Integer> rslt = new ArrayList<>();

 		helper(root, k1, k2, rslt);

 		return rslt;
	}

	public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> rslt){

		if(root == null){
			return;
		}

		if(root.val > k1){
			helper(root.left, k1, k2, rslt);
		}

		if(root.val >= k1 && root.val <= k2){
			rslt.add(root.val);
		}
		if(root.val < k2){
			helper(root.right, k1, k2, rslt);
		}
	}
}



































