public class LowestCommonAncestorii{
	public static class TreeNode{
		int val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val){
			this.val = val;
			left = right = null;
		}
	}


	public static void main(String args[]){
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		TreeNode temp = new TreeNode(8);
		LowestCommonAncestorii obj = new LowestCommonAncestorii();

		
	}


	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B){
        if(findNode(root, A) != true || findNode(root, B) != true){
            return null;
        }
        
        return helper(root, A, B);
	}

	public boolean findNode(TreeNode root, TreeNode source){
		if(root == null){
			return false;
		}
		if(root.val == source.val){
			return true;
		}

		return findNode(root.left, source) || findNode(root.right, source);


	}
	
	public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
		if(root == null || root == A || root == B){
			return root;
		}


		TreeNode left = helper(root.left, A, B);
		TreeNode right = helper(root.right, A, B);

		if(left != null && right != null){
			return root;
		}

		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}

		return null;	    
	}
	



}