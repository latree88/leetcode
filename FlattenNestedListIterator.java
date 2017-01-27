import java.util.*;

public class FlattenNestedListIterator{


    Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        NestedInteger temp = stack.pop();
        // if(temp.isInteger){
        return temp.getInteger();
        // }
        
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(!stack.isEmpty()){
        
            if(stack.peek().isInteger()){
                return true;
            }
            
            List<NestedInteger> tempList = stack.peek().getList();
            stack.pop();
            for(int i = tempList.size() - 1; i >= 0; i--){
                stack.push(tempList.get(i));
            }
        }
        return false;
    }

    @Override
    public void remove() {}

}





























