public class SearchInRotatedSortedArray{
	
	public static void main(String args[]){
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		int[] temp = {1, 2, 3};
		int rslt = obj.search(temp, 1);

		System.out.println(rslt);
	}

	public int search(int[] A, int target){
		if(A == null || A.length == 0){
			return -1;
		}

		int start = 0;
		int end = A.length - 1;

		while(start + 1 < end){
			int mid = start + (end - start) / 2;

			if(A[mid] == target){
				return mid;
			}
			if(A[start] < A[mid]){
				if(target <= A[mid] && A[start] <= target){
					end = mid;
				}
				else{
					start = mid;
				}
			}
			else{
				if(target >= A[mid] && target <= A[end]){
					start = mid;
				}
				else{
					end = mid;
				}

			}
		}

		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}
		return -1;



	} 
}