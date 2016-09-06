// ?????????????????????????????????????????


public class Triangle{
	public static void main(String args[]){
		Triangle obj = new Triangle();

		int[][] temp = {
						{-1},
    					{2,3},
   						{1,-1,-3}
		};
		int rslt = obj.minimumTotal(temp);
		System.out.println(rslt);
	}

	public int minimumTotal(int[][] triangle){
		if(triangle == null || triangle.length == 0 || triangle[0].length == 0){
			return 0;
		}

		int size = triangle.length;
		int[] dp = new int[size];

		dp[0] = triangle[0][0];
		

		for(int i = 1; i < size; i++){
			int tempMin = 0;
			for(int j = 1; j < triangle[i].length; j++){
				tempMin = Math.min(triangle[i][j - 1], triangle[i][j]);
			}
		
			dp[i] = dp[i - 1] + tempMin;
		}

		return dp[size - 1];
	}


}