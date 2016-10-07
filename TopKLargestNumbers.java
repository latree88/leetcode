public class TopKLargestNumbers{
	public static void main(String arg[]){
		int[] temp = {3,10,1000,-99,4,100};
		int k = 3;
	
		int[] res = new TopKLargestNumbers().topk(temp, k);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}



	public int[] topk(int[] nums, int k){
		quickSort(nums, 0, nums.length - 1);

		int cur;
		if(k < nums.length){
			cur = k;
		}
		else{
			cur = nums.length;
		}

		int right = nums.length;
		int[] res = new int[cur];
		for(int i = 0 ; i < cur; i++){
			res[i] = nums[right - 1];
			--right;
		}

		return res;
	}

	public void quickSort(int[] A, int start, int end){
		if(start >= end){
			return;
		}
		int left = start;
		int right = end;

		int pivot = A[(start + end) / 2];

		while(left <= right){
			while(left <= right && A[left] < pivot){
				++left;
			}

			while(left <= right && A[right] > pivot){
				--right;
			}

			if(left <= right){
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;

				++left;
				--right;
			}
		}

		quickSort(A, start, right);
		quickSort(A, left, end);


	}
}
















