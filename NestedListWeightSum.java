import java.util.*;
public class NestedListWeightSum{


 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 	public interface NestedInteger {

	    // @return true if this NestedInteger holds a single integer,
	     // rather than a nested list.
	     public boolean isInteger();

	     // @return the single integer that this NestedInteger holds,
	     // if it holds a single integer
	     // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();

	     // @return the nested list that this NestedInteger holds,
	     // if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	     public List<NestedInteger> getList();
	 }
 

	public int depthSum(List<NestedInteger> nestedList){
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>();
        
        for(NestedInteger one : nestedList){
            queue.offer(one);
        }
        
        int depth = 0;
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                NestedInteger temp = queue.poll();
                if(temp.isInteger()){
                    sum += temp.getInteger() * depth;
                }
                else{
                    for(NestedInteger one : temp.getList()){
                        queue.add(one);
                    }
                }
                
            }
            
        }
        
        return sum;	
	}


}














