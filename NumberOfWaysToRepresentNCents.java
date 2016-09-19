public class NumberOfWaysToRepresentNCents{
	public static void main(String args[]){

		int c = new NumberOfWaysToRepresentNCents().waysNCents(5);
		System.out.println(c);
	}	

	public int waysNCents(int n){
		int[] s = {1, 5, 10, 25};

		return coinChange(s, s.length, n);

	}

	public int coinChange(int[] coinTypes, int coinTypesLen , int n){
		if(n == 0){
			return 1;
		}

		if(n < 0){
			return 0;
		}

		int[][] dp = new int[coinTypesLen][n + 1];


		for(int i = 0; i < coinTypesLen; i++){
			dp[i][0] = 1;
		}

		for(int i = 0; i < coinTypesLen; i++){
			for(int j = 1; j < n + 1; j++){
				int x = (j >= coinTypes[i])? dp[i][j - coinTypes[i]] : 0;
				int y = (i >= 1)? dp[i - 1][j] : 0;

				dp[i][j] = x + y;
			}
		}

		return dp[coinTypesLen - 1][n];
	}
}