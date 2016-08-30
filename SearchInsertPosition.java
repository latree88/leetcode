class SearchInsertPosition{
	public static void main(String args[]){
		SearchInsertPosition obj = new SearchInsertPosition();
		int[] temp = {1, 2, 3, 4, 5, 9};
		int rslt = obj.searchInsert(temp, 0);
		System.out.println(rslt);
	}

	public int searchInsert(int[] A, int target){
		if(A == null || A.length == 0){
			return 0;
		}

		int start = 0;
		int end = A.length - 1;
		if(target < A[0]){
			return 0;
		}

		while(start + 1 <  end){
			int mid = start + (end - start) / 2;
			if(target ==  A[mid]){
				return mid;
			} 
			else if(target < A[mid]){
				end = mid;
			}
			else{
				start = mid;
			}
		}
		
		if(A[end] == target){
			return end;
		}
		if(A[end] < target){
			return end + 1;
		}
		if(A[start] == target){
			return start;
		}
		return start + 1;
	}
}