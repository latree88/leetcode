public class ClimbingStairsii{
	public static void main(String args[]){

	}

	public int climbStairs2(int n){
		if(n == 0){
			return 1;
		}

		if(n == 1){
			return 1;
		}

		int[] methodsCount = new int[n + 1];

		methodsCount[0] = 1;
		methodsCount[1] = 2;
		methodsCount[2] = 4;

		for(int i = 3; i < n; i++){
			methodsCount[i] = methodsCount[i - 1] + methodsCount[i - 2] + methodsCount[i - 3];
		}

		return methodsCount[n - 1];
	}
}