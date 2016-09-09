public class LongestCommonSubstring{

	public static void main(String args[]){
		LongestCommonSubstring obj = new LongestCommonSubstring();


	} 

	public int longestCommonSubstring(String A, String B){
		if(A == null || B == null || A.length() == 0 || B.length() == 0){
			return 0;
		}

		int row = A.length();
		int col = B.length();

		int[][] lngCmnSub = new int[row][col];
		int max = 0;

		for(int i = 0; i < row; i++){
			for (int j = 0; j < col; j++ ) {
				if(A.charAt(i) == B.charAt(j)){
					if(i == 0 || j == 0){
						lngCmnSub[i][j] = 1;
					}
					else{
						lngCmnSub[i][j] = lngCmnSub[i - 1][j - 1] + 1;
					}
					if(max < lngCmnSub[i][j]){
						max = lngCmnSub[i][j];
					}


				}
			}
		}

		return max;
	}
}