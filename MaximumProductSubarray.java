public class MaximumProductSubarray{

	public static void main(String args[]){
		int[] nums = {1,0,-1,2,3,-5,-2};

		int rslt = new MaximumProductSubarray().maxProduct(nums);

		// System.out.println(rslt);
	}


	public int maxProduct(int[] nums){
		int size = nums.length;

		int[] min = new int[size];
 		// int toCompare = Integer.MIN_VALUE;
		int[] max = new int[size];

		min[0] = max[0] = nums[0];
		int rslt = nums[0];

		for(int i = 1; i < size; i++){
			min[i] = max[i] = nums[i];

			if(nums[i] > 0){
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
			}
			else if(nums[i] < 0){
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);

			}

			rslt = Math.max(rslt, max[i]);
			// System.out.println(min[i]);

		}

		return rslt;

	}
}



































