public class MaximumSubarrayIII{

	public int maxSubArray(int[] nums, int k){
		if(nums.length < k){
			return 0;
		}

		int len =  nums.length;
		int[][] d = new int[len + 1][k + 1];
		for(int i = 0; i < len; i++){
			d[i][0] = 0;
		}

		for(int j = 1; j <= k; j++){
			for(int i = j; i <= len; i++){
				d[i][j] = Integer.MIN_VALUE;

				int endMax = 0;
				int max = Integer.MIN_VALUE;
				for(int p = i -1; p >= j - 1; p--){
					endMax = Math.max(nums[p], endMax + nums[p]);
					max = Math.max(endMax, max);
					if(d[i][j] < d[p][j -1 ] + max){
						d[i][j] = d[p][j - 1] + max;
					}
				}



			}
		}
		return d[len][k];
	}
}













