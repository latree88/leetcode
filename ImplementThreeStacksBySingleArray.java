public class ImplementThreeStacksBySingleArray{

	private int[][] array;



	public ImplementThreeStacksBySingleArray(int size){
		array = new int[3][size + 1];
		for(int i = 0; i < 3; i++){
			array[i][size] = -1; 
		}


	}


	public void push(int stackNum, int value){
		int size = array[stackNum].length - 1;
		int tempStackTop = array[stackNum][size];
		if(tempStackTop + 1< size){
			array[stackNum][tempStackTop + 1] = value;
			array[stackNum][size] = tempStackTop + 1;
		}
	}

	public int pop(int stackNum){
		int size = array[stackNum].length - 1;
		int tempStackTop = array[stackNum][size];
		if(tempStackTop < 0){
			return -1;
		}
		else{
			int res = array[stackNum][tempStackTop];
			array[stackNum][size] = tempStackTop - 1;
			return res;
		}
	}


	public int peek(int stackNum){
		int size = array[stackNum].length - 1;
		int tempStackTop = array[stackNum][size];
		if(tempStackTop < 0){
			return -1;
		}
		else{
			return array[stackNum][tempStackTop];
		}
	}

	public boolean isEmpty(int stackNum){
		int size = array[stackNum].length - 1;
		int tempStackTop = array[stackNum][size];
		if(tempStackTop < 0){
			return true;
		}
		else{
			return false;
		}
	}



}

























