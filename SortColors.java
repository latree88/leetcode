public class SortColors{
	public static void main(String args[]){

	}


	public void sortColors(int[] nums){
		if(nums == null || nums.length == 0){
			return;

		}

		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while(i <= right){
			if(nums[i] == 0){
				swap(nums, left, i);
				++left;
				++i;
			}
			else if(nums[i] == 1){
				++i;

			}
			else{
				swap(nums, right, i);
				--right;
			}
		}

		return;

	}


	public void swap(int[] A, int indexI, int indexJ){
		int temp = A[indexI];
		A[indexI] = A[indexJ];
		A[indexJ] = temp;
	}
}