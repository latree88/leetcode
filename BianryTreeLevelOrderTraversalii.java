import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;


public class BinaryTreeLevelOrderTraversal{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}


	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
		ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();

		if(root == null){
			return rslt;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode temp = queue.poll();
				level.add(temp.val);

				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null){
					queue.add(temp.right);
				}
			}

			rslt.add(new ArrayList<Integer>(level));
		}

		Collections.reverse(rslt);
		return rslt;


	}
}












































