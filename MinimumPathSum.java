public class MinimumPathSum{
	public static void main(String args[]){
		MinimumPathSum obj = new MinimumPathSum();

		int[][] temp = {
						{1,2},
						{3,4},
						{5,6}
						};
		int rslt = obj.minPathSum(temp);
		System.out.println(rslt);
	}

	public int minPathSum(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;

		int[][] dp = new int[row + 1][col + 1];
		dp[0][0] = grid[0][0];

		for(int i = 1; i < row; i++){
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}

		for(int i = 1; i < col; i++){
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}

		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[row - 1][col - 1];
	}
}