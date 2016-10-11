import java.util.Stack;


public class ImplementQueueByTwoStacks{
	public static void main(String args[]){

	}

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public ImplementQueueByTwoStacks(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int element){
		stack2.push(element);
	}

	public int pop(){
		if(stack1.empty() == true){
			while(stack2.empty() != true){
				stack1.push(stack2.pop());
			}

		}
		return stack1.pop();
	}


	public int top(){
		if(stack1.empty() == true){
			while(stack2.empty()!= true){
				stack1.push(stack2.pop());
			}
		}

		return stack1.peek();
	}

}





























