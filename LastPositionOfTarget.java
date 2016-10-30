public class LastPositionOfTarget{

	public static void main(String args[]){
		int[] nums = {1,2,2,4,5,5};
		int target = 6;

		LastPositionOfTarget obj = new LastPositionOfTarget();
		int rslt = obj.lastPosition(nums, target);

		System.out.println(rslt);
	}

	public int lastPosition(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			
			if(nums[mid] < target){
				start = mid;
			}
			else if(nums[mid] > target){
				end = mid;
			}
			else{
				start = mid;
			}

		}


		if(nums[end] == target){
			return end;
		}
		if(nums[start] == target){
			return start;
		}
		return -1;

	}


}






















