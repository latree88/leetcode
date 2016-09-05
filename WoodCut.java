public class WoodCut{

	public static void main(String args[]){
		WoodCut obj = new WoodCut();

		int[] temp = {2147483644,2147483645,2147483646,2147483647};
		int k = 4;

		int rslt = obj.woodCut(temp, k);
		System.out.println(rslt);	
	}

	public int woodCut(int[] L, int k){
		if(L == null || L.length == 0){
			return 0;
		}
		int leftSide = 0;

		for(int i = 0; i < L.length; i++){
			leftSide = Math.max(leftSide, L[i]);
		}

		int start = 1;
		int end = leftSide;

		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(getNumOfPiece(L, mid) >= k){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(getNumOfPiece(L, end) >= k){
			return end;
		}

		if(getNumOfPiece(L, start) >= k){
			return start;
		}

		return 0;



	}

	public int getNumOfPiece(int[] L, int len){
		int sum = 0;
		for(int i = 0; i < L.length; i++){
			sum += L[i] / len;
		}	

		return sum;
	}
}