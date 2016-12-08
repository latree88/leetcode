public class MaximumSubarrayDifference{


	public int maxDiffSubArrays(int[] nums){
		int size = nums.length;
		int[] left_max = new int[size];
		int[] right_max = new int[size];
		int[] left_min = new int[size];
		int[] right_min =new int[size];
		int[] copy = new int[size];

		for(int i = 0; i < size; i++){
			copy[i] = -1 * nums[i];
		}
		int max = Integer.MIN_VALUE;
		int minSum = 0;
		int sum = 0;

		for(int i = 0; i < size; i++){
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);

			left_max[i] = max;
		}

	
		max = Integer.MIN_VALUE;
		minSum = 0;
		sum = 0;

		for(int i = size - 1; i >= 0; i--){
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);

			right_max[i] = max;
		}


		max = Integer.MIN_VALUE;
		minSum = 0;
		sum = 0;

		for(int i = 0; i < size; i++){
			sum += copy[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);

			left_min[i] = -1 * max;			
		}

		max = Integer.MIN_VALUE;
		minSum = 0;
		sum = 0;

		for(int i = size - 1; i >= 0; i--){
			sum += copy[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);

			right_min[i] = -1 * max;
		}

		int diff = 0;
		for(int i = 0; i < size - 1; i++){
			diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
			diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
		}

		return diff;
	}
}
























