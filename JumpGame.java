public class JumpGame{
	
	public static void main(String args[]){
		JumpGame obj = new JumpGame();

		int[] temp = {3,2,1,0,4};

		boolean hold = obj.canJump(temp);

		if(hold){
			System.out.println("1");
		}
		else{
			System.out.println("0");

		}


	}

	public boolean canJump(int[] A){
		if(A == null){
			return false;
		}

		int size = A.length;
		boolean[] step = new boolean[size];

		step[0] = true;
		for(int i = 1; i < size; i++){
			for (int j = 0; j < i; j++ ) {
				if(step[j] && j + A[j] >=i){
					step[i] = true;
					break;
				}
			}
		}

		return step[size - 1];

	}
}