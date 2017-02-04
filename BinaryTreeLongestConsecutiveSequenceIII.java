public class BinaryTreeLongestConsecutiveSequenceIII{
	public class MultiTreeNode {
		int val;
		List<MultiTreeNode> children;
		MultiTreeNode(int x) { val = x; }
	}	

    public class ResultType{
        int maxLength, maxDown, maxUp;
        
        public ResultType(int down, int up, int length){
            maxDown = down;
            maxUp = up;
            maxLength = length;
        }
    }
    
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).maxLength;
        
    }
    
    public ResultType helper(MultiTreeNode root){
        if(root == null){
            return new ResultType(0, 0, 0);
        }
        
        int down  = 0;
        int up = 0;
        int maxLen = 1;
        for(MultiTreeNode one : root.children){
            ResultType temp = helper(one);

            if(root.val + 1 == one.val){
                down = Math.max(down, temp.maxDown + 1);
            }
            if(root.val - 1 == one.val){
                up = Math.max(up, temp.maxUp + 1);
            }
            
            maxLen = Math.max(maxLen, temp.maxLength);
        }
        
        maxLen = Math.max(maxLen, down + up + 1);
        return new ResultType(down, up, maxLen);
        
    }	
}
















