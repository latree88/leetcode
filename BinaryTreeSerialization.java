import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeSerialization{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public String serialize(TreeNode root){
		if(root == null){
			return "{}";
		}

		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);

		for(int i = 0; i < queue.size(); i++){
			TreeNode temp = queue.get(i);

			if(temp == null){
				continue;
			}
			queue.add(temp.left);
			queue.add(temp.right);
		}

		while(queue.get(queue.size() - 1) == null){
			queue.remove(queue.size() - 1);
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append(queue.get(0).val);

		for(int i = 1; i < queue.size(); i++){
			if(queue.get(i) == null){
				sb.append(",#");
			}
			else{
				sb.append(",");
				sb.append(queue.get(i).val);
			}
		}

		sb.append("}");
		return sb.toString();

 
	}

	public TreeNode deserialize(String data){
		if(data == "{}"){
			return null;
		}

		String[] vals = data.substring(1, data.length() - 1).split(",");
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

		queue.add(root);
		int index = 0;
		boolean isLeftChild = true;

		for(int i = 1; i < vals.length; i++){
			if(!vals[i].equals("#")){
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				if(isLeftChild){
					queue.get(index).left = node;

				}
				else{
					queue.get(index).right = node;
				}

				queue.add(node);

			}
			if(!isLeftChild){
				index++;
			}
			isLeftChild = !isLeftChild;

		}

		return root;
	}
}








































