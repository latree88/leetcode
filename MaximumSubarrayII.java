import java.util.*;


public class MaximumSubarrayII{


	public int maxTwoSubArrays(ArrayList<Integer> nums){

		int size = nums.size();
		int[] left_max = new int[size];
		int[] right_max = new int[size];

		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;

		for(int i = 0; i < size; i++){
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);

			left_max[i] = max;
		}


		max = Integer.MIN_VALUE;
		sum = 0;
		minSum = 0;

		for(int i = size - 1; i >= 0; i--){
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(sum, minSum);
	
			right_max[i] = max;			
		}

		int finalSum = Integer.MIN_VALUE;
		for(int i = 0; i < size - 1; i++){
			finalSum  = Math.max(finalSum, left_max[i] + right_max[i + 1]);
		}

		return finalSum;
	}
}