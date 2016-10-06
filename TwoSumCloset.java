import java.util.Arrays;

public class TwoSumCloset{
	public static void main(String args[]){
		int[] nums = {-1,2,1,-4};
		int target = 4;

		int rslt = new TwoSumCloset().twoSumCloset(nums, target);

		System.out.println("rslt: " + rslt); 

	}


	public int twoSumCloset(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		int diff = Integer.MAX_VALUE;

		while(i < j){
			if(nums[i] + nums[j] < target){
				if(target - nums[i] - nums[j] < diff){
					diff = target - nums[i] - nums[j];
				}

				++i;
			}
			else{
				if(nums[i] + nums[j] - target < diff){
					diff = nums[i] + nums[j] - target;
				}

				--j;
			}
		}

		return diff;

	}

}