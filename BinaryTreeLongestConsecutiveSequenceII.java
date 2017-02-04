public class BinaryTreeLongestConsecutiveSequenceII{


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public class ResultType{
        int maxDown, maxUp, maxLength;
        
        public ResultType(int down, int up, int length){
            maxDown = down;
            maxUp = up;
            maxLength = length;
        }
    }
    
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        
        return help(root).maxLength;
    }
    
    public ResultType help(TreeNode root){
        if(root == null){
            return new ResultType(0, 0, 0);
        }
        
        ResultType left = help(root.left);
        ResultType right =  help(root.right);
        
        int down = 0;
        int up = 0;
        
        if(root.left != null && root.val + 1 == root.left.val){
            down = Math.max(down, left.maxDown + 1);
        }
        
        
        if(root.left != null && root.val - 1 == root.left.val){
            up = Math.max(up, left.maxUp + 1);
        }
        
        
        if(root.right != null && root.val + 1 == root.right.val){
            down = Math.max(down, right.maxDown + 1);
        }
        
        if(root.right != null && root.val - 1 == root.right.val){
            up = Math.max(up, right.maxUp + 1);
        }
        
        int len = down + up + 1;
        len = Math.max(len, Math.max(left.maxLength, right.maxLength));
        
        return new ResultType(down, up, len);
    }
    
    
   

}










