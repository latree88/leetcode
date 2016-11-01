public class ConstructBinaryTreeFromPreorderAndInorderTraversal{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(inorder.length != preorder.length){
			return null;
		}

		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

	public TreeNode myBuildTree(int[] inorder, int inStart, int inEnd, 
								int[] preorder, int preStart, int preEnd){

		if(inStart > inEnd){
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int pos = findPosition(inorder, inStart, inEnd, preorder[preStart]);

		root.left = myBuildTree(inorder, inStart, pos - 1,
								preorder, preStart + 1, preStart + pos - inStart);

		root.right = myBuildTree(inorder, pos + 1, inEnd,
								 preorder, pos - inEnd + preEnd + 1 ,preEnd);
		return root;
	}

	public int findPosition(int[] inorder, int inStart, int inEnd, int key){
		int i;
		for(i = inStart; i <= inEnd; i++){
			if(inorder[i] == key){
				return i;
			}
		}

		return -1;
	}
}


















