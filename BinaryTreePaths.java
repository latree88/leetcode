import java.util.*;

public class BinaryTreePaths{

	public class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new ArrayList<>();

		if(root == null){
			return res;
		}

		List<String> leftPaths = binaryTreePaths(root.left);
		List<String> rightPaths = binaryTreePaths(root.right);

		for(String path : leftPaths){
			res.add(root.val + "->" + path);
		}


		for(String path : rightPaths){
			res.add(root.val + "->" + path);
		}

		if(res.size() == 0){
			res.add("" + root.val);
		}

		return res;
	}
}























