public class RemoveNodeInBinarySearchTree{
	public static class TreeNode{
		int val;
		TreeNode left, right;

		public TreeNode(int source){
			this.val = source;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(1);
		root.right = new TreeNode(40);
		root.right.left = new TreeNode(35);



	}

	// first, find the target node to delete
	// also need to find target node's parent
    public TreeNode removeNode(TreeNode root, int value){
        if(root == null){
            return null;
        }
        TreeNode nodeHelper = new TreeNode(0);
        nodeHelper.left = root;

        TreeNode parent = findNode(root, value, nodeHelper);
        TreeNode toDelete;

        if(parent.left != null && parent.left.val == value){
            toDelete = parent.left;
        }
        else if(parent.right != null && parent.right.val == value){
            toDelete = parent.right;
        }
        else{
            return nodeHelper.left;
        }

        removeHelper(parent, toDelete);
        return nodeHelper.left;
    }

    // find target node's parents
    public TreeNode findNode(TreeNode root, int value, TreeNode myParent){
        if(root == null){
            return myParent;
        }
        if(root.val == value){
            return myParent;
        }

        if(root.val < value){
            return findNode(root.right, value, root);
        }
        else{
            return findNode(root.left, value, root);
        }


    }

    public void removeHelper(TreeNode myParent, TreeNode deleteTarget){
        // there are three case need to consider
    	// 1. target node has no children
    	// 2. target node has one child
    	// 3. target node has two children

    	// first case.
    	// delete that target node
        if(deleteTarget.left == null && deleteTarget.right == null){
            if(myParent.left == deleteTarget){
                myParent.left = null;
            }
            else{
                myParent.right = null;
            }
        }
        // second case
        // delete that node and connect parents and child
        else if(deleteTarget.left != null && deleteTarget.right == null){
            if(myParent.left == deleteTarget){
                myParent.left = deleteTarget.left;
            }
            else{
                myParent.right = deleteTarget.left;
            }
        }
        else if(deleteTarget.left == null && deleteTarget.right != null){
            if(myParent.left == deleteTarget){
                myParent.left = deleteTarget.right;
            }
            else{
                myParent.right = deleteTarget.right;
            }
        }

        // third case
        // find the minimum larger number that greater than target node
        // replace target node value with that minimum larger number
        // delete that minimum larger number node
        else{
            TreeNode minNode = findMinNode(deleteTarget);

            deleteTarget.val = minNode.left.val;
            minNode.left = null;
        }
    }
    public TreeNode findMinNode(TreeNode root){
        TreeNode cur = root.right;
        if(cur.left != null){
            while(cur.left.left != null){
                cur = cur.left;
            }
        }

        return cur;
    }
}