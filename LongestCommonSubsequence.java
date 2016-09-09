public class LongestCommonSubsequence{
	public static void main(String args[]){
		LongestCommonSubsequence obj = new LongestCommonSubsequence();

		String A = "ABCD";
		String B = "EACB";

		int rslt = obj.longestCommonSubsequence(A, B);
		System.out.println(rslt);
	}

	public int longestCommonSubsequence(String A, String B){
		if(A == null || B == null || A.length() == 0 || B.length() == 0){
			return 0;
		}

		int row = A.length();
		int col = B.length();

		int[][] lngCmnSub = new int[row + 1][col + 1];



		for(int i = 0; i <= row; i++){
			for(int j = 0; j <= col; j++){

				if(i == 0 || j == 0){
					lngCmnSub[i][j] = 0;
				}
				else if(A.charAt(i - 1) == B.charAt(j - 1)){
					lngCmnSub[i][j] = 1 + lngCmnSub[i - 1][j - 1];
				}
				else{
					lngCmnSub[i][j] = Math.max(lngCmnSub[i][j - 1], lngCmnSub[i - 1][j]);
				}


			}
		}

		return lngCmnSub[row][col];

	}
}