import java.util.Stack;

public class BinarySearchTreeIterator{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}	

	public static void main(String args[]){

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);


	}

	public Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        // write your code here
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
        	stack.push(cur);
        	cur = cur.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();

    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
    	if(stack == null){
    		return null;
    	}
    	TreeNode temp = stack.pop();

    	TreeNode rslt = new TreeNode(temp.val);

    	if(temp.right != null){
    		temp = temp.right;

    		while(temp != null){
    			stack.push(temp);
    			temp = temp.left;
    		}
    	}

    	return rslt;

    }






















}