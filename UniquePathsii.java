// be carefule that obstacle can be in the first row and first column

public class UniquePathsii{
	public static void main(String arg[]){
		UniquePathsii obj = new UniquePathsii();

		int[][] temp = {
						{0,0},
  						{0,0},
  						{0,0},
  						{1,0},
  						{0,0}
						};
		int rslt = obj.uniquePathsWithObstacles(temp);

		System.out.println(rslt);

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
			return 0;
		}

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;

		int[][] dp = new int[row][col];

		for(int i = 0; i < row; i++){
			if(obstacleGrid[i][0] != 1){
				dp[i][0] = 1;
			}
			else{
				break;
			}

		}

		for(int i = 0; i < col; i++){
			if(obstacleGrid[0][i] != 1){
				dp[0][i] = 1;
			}
			else{
				break;
			}
		}


		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				if(obstacleGrid[i][j] == 1){
					dp[i][j]  = 0;
				}
				else{
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[row - 1][col - 1];
	}
}