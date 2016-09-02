import java.util.ArrayList;
import java.util.*;	

public class BinaryTreeLevelOrderTraversal{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}	

	public static void main(String args[]){
		BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);


	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> rslt = new ArrayList<ArrayList<Integer>>();

		if(root == null){
			return rslt;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(queue.isEmpty() != true){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();			
			for(int i = 0; i < size; i++){
				TreeNode head = queue.poll();
				level.add(head.val);

				if(head.left != null){
					queue.add(head.left);
				}
				if(head.right != null){
					queue.add(head.right);
				}
			}
			rslt.add(new ArrayList<Integer>(level));

		}

		return rslt;

	} 

}