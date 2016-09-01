import java.util.ArrayList;

public class BinaryTreePreorderTraversal{

	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> rslt = obj.preorderTraversal(root);

		System.out.println(rslt);
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> rslt = new ArrayList<>();

		helper(root, rslt);
		return rslt;
	}

	public void helper(TreeNode root, ArrayList<Integer> rslt){
		if(root == null){
			return;
		}

		rslt.add(root.val);
		helper(root.left, rslt);
		helper(root.right, rslt);

	}


}