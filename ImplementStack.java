import java.util.*;

public class ImplementStack{

	List<Integer> list = new ArrayList<>();
	public void push(int x){
		list.add(x);
	}

	public void pop(){
		if(list.size() != 0){
			list.remove(list.size() - 1);		
		}

	}


	public int top(){
		return list.get(list.size() - 1);

	}

	public boolean isEmpty(){

		if(list.size() != 0){
			return false;
		}
		return true;
		
	}


}











