public class KClosetNumbersInSortedArray{
	public static void main(String args[]){
		int[] temp = {1, 4, 6, 8};
		int target  = 3;
		int k = 3;

		int[] rslt = new KClosetNumbersInSortedArray().kClosestNumbers(temp, target, k);

		
		// System.out.println("%%%%%%%%%%%%%");


		for(int i = 0; i < rslt.length; i++){
			System.out.println(rslt[i]);
		}

	}

	public int[] kClosestNumbers(int[] A, int target, int k){
		
		// find the index of target
		if(A == null){
			return null;
		}
		if(k == 0){
			int[] rslt = {};
			return rslt;
		}

		int start = 0;
		int end = A.length - 1;
		int targetIndex = -1;
		int[] rslt = new int[k];

		while(start + 1 < end){
			int mid = start + (end  - start) / 2;

			if(A[mid] == target){
				targetIndex = mid;
				break;
			}
			else if(A[mid] < target){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(targetIndex == -1){
			if(A[start] >= target){
				targetIndex = start;
			}
			else if(A[end] <= target){
				targetIndex = end;
			}
			else{

				if(target - A[start] <= A[end] - target){
					targetIndex = start;
				}
				else{
					targetIndex = end;
				}
			}


		}

		// start to find all numbers in k closet
		int leftRange = 1;
		int rightRange = 1;
		int count = 0;

		rslt[0] = A[targetIndex];
		++count;

		while(count < k){
			if((targetIndex - leftRange < 0) && 
				(targetIndex + rightRange <= A.length - 1)){
				rslt[count] = A[targetIndex + rightRange];
				++rightRange;
			}
			else if((targetIndex - leftRange >= 0) && 
					(targetIndex + rightRange > A.length - 1)){
				rslt[count] = A[targetIndex - leftRange];
				++leftRange;
			}
			else if((targetIndex - leftRange >= 0) && 
					(targetIndex + rightRange <= A.length - 1)){
				int minVal = Math.min((target - A[targetIndex - leftRange]),
						(A[targetIndex + rightRange] - target));
				if(minVal == (target - A[targetIndex - leftRange])){
					rslt[count] = A[targetIndex - leftRange];
					++leftRange;
				}
				else{
					rslt[count] = A[targetIndex + rightRange];
					++rightRange;
				}
			}
			else{


				return rslt;
			}
			// 	System.out.println("TI: " + targetIndex);
			// 	System.out.println("leftRange: " + leftRange);
			// 	System.out.println("rightRange: " + rightRange);

			// System.out.println("count : " + count);
			
			++count;
		}

		return rslt;
	}

}