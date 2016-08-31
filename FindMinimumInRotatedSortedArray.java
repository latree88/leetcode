public class FindMinimumInRotatedSortedArray{
	
	public static void main(String args[]){
		FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
		int[] temp = {4, 5, 6, 7, 0, 1, 2};
		int rslt = obj.findMin(temp);
		System.out.println(rslt);
	}

	public int findMin(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;
		int target = nums[nums.length - 1];

		while(start + 1 < end){
			int mid  = start + (end - start) / 2;
			if(target <= nums[mid]){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(nums[start] <= target){
			return nums[start];
		}
		return nums[end];
	}

}