import java.util.*;


public class StackSorting{

	public void stackSorting(Stack<Integer> stack){
		Stack<Integer> tempStack = new Stack<Integer>();

		while(!stack.isEmpty()){
			if(tempStack.isEmpty() || (!tempStack.isEmpty() && stack.peek() <= tempStack.peek())){
				tempStack.push(stack.pop());
			}
			else{
				int value = stack.pop();
				while(!tempStack.isEmpty() && tempStack.peek() <= value){
					stack.push(tempStack.pop());
				}
				stack.push(value);

				while(!tempStack.isEmpty()){
					stack.push(tempStack.pop());
				}

			}

		}

		while(!tempStack.isEmpty()){
			stack.push(tempStack.pop());
		}
	}



}

















