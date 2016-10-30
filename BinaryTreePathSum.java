import java.util.List;
import java.util.ArrayList;


public class BinaryTreePathSum{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target){
		List<List<Integer>> rslt = new ArrayList<>();

		if(root == null){
			return rslt;
		}

		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(root.val);

		helper(root, target, rslt, path, root.val);

		return rslt;
		
	}


	public void helper(TreeNode root, 
					   int target, 
					   List<List<Integer>> rslt,
					   ArrayList<Integer> path, 
					   int sum){
		if(root.left == null && root.right == null){
			
			if(sum == target){
				rslt.add(new ArrayList<Integer>(path));
			}
			return;
		}

		if(root.left != null){
			path.add(root.left.val);
			helper(root.left, target, rslt, path, sum + root.left.val);
			path.remove(path.size() - 1);
		}

		if(root.right != null){
			path.add(root.right.val);
			helper(root.right, target, rslt, path, sum + root.right.val);
			path.remove(path.size() - 1);
		}
	}


}




































