import java.util.Stack;
import java.util.ArrayList;



public class BinaryTreeZigzagLevelOrderTraversal{


	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){

		ArrayList<ArrayList<Integer>> rslt =  new ArrayList<>();

		if(root == null){
			return rslt;
		}

		Stack<TreeNode> curLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		Stack<TreeNode> tempStack;

		curLevel.push(root);
		boolean normalOrder = true;

		while(!curLevel.isEmpty()){
			ArrayList<Integer> level = new ArrayList<>();

			while(!curLevel.isEmpty()){
				TreeNode temp = curLevel.pop();
				level.add(temp.val);

				if(normalOrder){
					if(temp.left != null){
						nextLevel.push(temp.left);

					}
					if(temp.right != null){
						nextLevel.push(temp.right);
					}
				}
				else{
					if(temp.right != null){
						nextLevel.push(temp.right);
					}	
					if(temp.left != null){
						nextLevel.push(temp.left);

					}
				}
			}

			rslt.add(new ArrayList(level));
			tempStack = curLevel;
			curLevel = nextLevel;
			nextLevel = tempStack;
			normalOrder = !normalOrder;
		}

		return rslt;

	}
}














































