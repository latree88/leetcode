public class LongestIncreasingSubsequence{
	public static void main(String args[]){
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] temp = {5, 4, 1, 2, 3};
		int rslt = obj.longestIncreasingSubsequence(temp);

	}

	public int longestIncreasingSubsequence(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}

		int size = nums.length;
		int[] dp = new int[size];
		
		int max = 0;
		for(int i = 0; i < size; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(nums[j] < nums[i]){
					if(dp[i] <= dp[j] + 1){
						dp[i] = dp[j] + 1;
					}
				}
			}

			if(dp[i] > max){
				max = dp[i];
			}
		}

		return max;
	}	


}