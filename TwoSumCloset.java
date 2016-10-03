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

		int diff = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				if(i != j){
					int temp = Math.abs(target - (nums[i] + nums[j]));

					diff = Math.min(diff, temp);
					// System.out.println("temp: " + temp);
					// System.out.println("diff: " + diff);

				}
			}
		}

		return diff;

	}

}