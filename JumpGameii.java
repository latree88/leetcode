public class JumpGameii{
	public static void main(String args[]){
		JumpGameii obj = new JumpGameii();
		int[] temp = {2,3,1,1,4};

		int rslt = obj.jump(temp);
		System.out.println(rslt	); 

	}

	public int jump(int[] A){
		if(A == null){
			return 0;
		}

		int size = A.length;
		int[] step = new int[size];

		step[0] = 0;
		for(int i = 1; i < size; i++){
			step[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++){
				if(step[j] != Integer.MAX_VALUE && j + A[j] >= i){
					step[i] = step[j] + 1;
					break;
				}
			}
		}

		return step[size - 1];
	}
}