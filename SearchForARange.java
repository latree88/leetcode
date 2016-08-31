public class SearchForARange{
	public static void main(String args[]){
		SearchForARange obj = new SearchForARange();
		int[] temp = {5, 7, 7, 8, 8, 10};
		int[] rslt = obj.searchRange(temp, 10);
		System.out.println(rslt[0]);
		System.out.println(rslt[1]);

	}

	public int[] searchRange(int[] A, int target){
		int[] rslt = {-1, -1};

		if(A == null || A.length == 0){
			return rslt;
		}

		int start = 0;
		int end = A.length - 1;

		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(A[mid] < target){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(A[start] == target){
			rslt[0] = start;
			if(A.length == 1){
				rslt[1] = start;
				return rslt;
			}
			else{
				int i = start;
				while(A[i] == target){
					i++;
					if(i == A.length){
						break;
					}
				}
				rslt[1] = i - 1;
				return rslt;
			}
		}

		if(A[end] == target){
			rslt[0] = end;
			if(A.length == 1){
				rslt[1] = end;
				return rslt;
			}
			else{
				int i = end;
				while(A[i] == target){
					i++;
					if(i == A.length){
						break;
					}
				}
				rslt[1] = i - 1;
				return rslt;
			}
		}

		return rslt;
	}
}