import java.util.*;



public class ImplementStackByTwoQueues{

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>(); 

	public void push(int x){
		q1.add(x);
	}

	public void pop(){
		int size = q1.size();
		if(size == 0){
		    return;
		}
		
        while(size > 1){
            q2.offer(q1.poll());
            size--;
        }
        int ret = q1.poll();

        
        while(q2.size() != 0){
            q1.offer(q2.poll());
        }
        
	}

	public int top(){
		int size = q1.size();
		if(size == 0){
		    return -1;
		}
		
        while(size > 1){
            q2.offer(q1.poll());
            size--;
        }
        int ret = q1.peek();
        q2.offer(q1.poll());
        
        while(q2.size() != 0){
            q1.offer(q2.poll());
        }
        return ret;
	}

	public boolean isEmpty(){
		if(q1.size() == 0){
			return true;
		}
		return false;
	} 
}












