//When you see string problem that is about subsequence 
//or matching, dynamic programming method should come to 
//your mind naturally.


public class DistinctSubsequences{
	public static void main(String args[]){
		DistinctSubsequences obj = new DistinctSubsequences();
		String source = "rabbbit";
		String target = "rabbit";

		int rslt = obj.numDistinct(source, target);
		System.out.println(rslt);
	}

	public int numDistinct(String S, String T){
		if(T == null || S == null){
			return 0;
		}

		int row = S.length();
		int col = T.length();

		int[][] dp = new int[row + 1][col + 1]; 
		
		for(int i = 0; i < row + 1; i++){
			dp[i][0] = 1;
		}

		for(int i = 1; i < row + 1; i++){
			char source = S.charAt(i - 1);
			for(int j = 1; j < col + 1; j++){
				char target = T.charAt(j - 1);
				dp[i][j] = dp[i - 1][j];
				if(source == target){
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[row][col];

	}	


}