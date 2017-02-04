import java.util.*;


public class BinaryTreePathSumIII{

	 class ParentTreeNode {
	     public int val;
	     public ParentTreeNode parent, left, right;
	 }


    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        dfs(root, target, res);
        return res;
    }
    
    public void dfs(ParentTreeNode root, int target, List<List<Integer>> res){
        if(root == null){
            return;
        }
        
        List<Integer> path = new ArrayList<>();
        findSum(root, null, target, path, res);
        
        dfs(root.left, target, res);
        dfs(root.right,target, res);
    }
    
    
    public void findSum(ParentTreeNode root,
                        ParentTreeNode father, 
                        int target, 
                        List<Integer> path,
                        List<List<Integer>> res){
        
        path.add(root.val);
        target -= root.val;
        
        if(target == 0){
            res.add(new ArrayList(path));
        }
        
        if(root.parent != null && root.parent != father){
            findSum(root.parent, root, target, path, res);
        }
        
        
        if(root.left != null && root.left != father){
            findSum(root.left, root, target, path, res);
        }
        
        
        if(root.right != null && root.right != father){
            findSum(root.right, root, target, path, res);
        }
        
        path.remove(path.size() - 1);
                            
    }
}













