public class FindPeakElement{
	public static void main(String args[]){
		FindPeakElement obj = new FindPeakElement();
		int[] temp = {1, 2, 1, 3, 4, 5, 7, 6};
		int rslt = obj.findPeak(temp);
		System.out.println(rslt); 

	}

	public int findPeak(int[] A){
		if(A == null || A.length == 0){
			return -1;
		}

		int start = 1;
		int end = A.length - 2;

		while(start + 1 < end){
			int mid = (start + end) / 2;
			if(A[mid] < A[mid - 1]){
				end = mid;
			}
			else if(A[mid] < A[mid + 1]){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(A[start] < A[end]){
			return end;
		}
		else{
			return start;
		}
	}
}