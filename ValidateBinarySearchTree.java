// key point:
// inorder traverse is able to store the inorder successor for each node!!!!!!!

public class ValidateBinarySearchTree{
	public static class TreeNode{
		public int val;
		public TreeNode left, right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]){
		ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);

		boolean temp = obj.isValidBST(root);

		int rslt = (temp)? 1 : 0;
		System.out.println(rslt);

	}

    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {

            return false;
        }
        firstNode = false;

        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}