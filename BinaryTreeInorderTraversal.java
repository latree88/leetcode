import java.util.ArrayList;


public class BinaryTreeInorderTraversal{




	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> rslt  = new ArrayList<>();
		if(root == null){
			return rslt;
		}

		helper(root, rslt);
		return rslt;

	}

	public void helper(TreeNode root, ArrayList<Integer> rslt){
		if(root == null){
			return;
		}

		helper(root.left, rslt);
		rslt.add(root.val);
		helper(root.right, rslt);
	}
}










































