public class EditDistance{
	public static void main(String args[]){
		EditDistance obj = new EditDistance();
		String word1 = "mart";
		String word2 = "karma";

		int rslt = obj.minDistance(word1, word2);
		System.out.println(rslt);

	}

	public int minDistance(String word1, String word2){
		if(word2 == null && word1 == null){
			return 0;
		}
		if(word2 == null && word1 != null){
			return word1.length();
		}

		if(word2 != null && word1 == null){
			return word2.length();
		}

		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];

		for(int i = 0; i < m + 1; i++){
			dp[i][0] = i;
		}


		for(int i = 0; i < n + 1; i++){
			dp[0][i] = i;
		}


		// insert m - 1 
		// delete n - 1
		// replace m - 1 and n - 1
		for(int i = 1; i < m + 1; i++){
			char word1Char = word1.charAt(i - 1);
			for(int j = 1; j < n + 1; j++){
				char word2Char = word2.charAt(j - 1);

				if(word1Char == word2Char){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					int insert = dp[i - 1][j] + 1;
					int delete = dp[i][j - 1] + 1;
					int replace = dp[i - 1][j - 1] + 1;

					dp[i][j] = Math.min(replace,(Math.min(insert, delete)));
				}
			}
		}
		return dp[m][n];
	}


}











