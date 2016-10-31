import java.util.ArrayList;





public class LowestCommonAncestorii{

	public static class ParentTreeNode{
		public ParentTreeNode parent, left, right;
	}




	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
												 ParentTreeNode A,
												 ParentTreeNode B){
		if(root == null){
			return null;
		}

		ParentTreeNode lowestCommonAncestor = null;



		ArrayList<ParentTreeNode> pathA = path2Root(A);
		ArrayList<ParentTreeNode> pathB = path2Root(B);

		int indexA = pathA.size() - 1;
		int indexB = pathB.size() - 1;

		while(indexA >= 0 && indexB >= 0){
			if(pathA.get(indexA) != pathB.get(indexB)){
				break;
			}

			lowestCommonAncestor = pathA.get(indexA);
			--indexA;
			--indexB; 
		}

		return lowestCommonAncestor;


	}

	public ArrayList<ParentTreeNode> path2Root(ParentTreeNode node){
		ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
		while(node != null){
			path.add(node);
			node = node.parent;
		}
		return path;
	}
}























