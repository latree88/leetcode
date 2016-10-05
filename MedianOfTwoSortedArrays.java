public class MedianOfTwoSortedArrays{
	public static void main(String args[]){

	}


	public double findMedianSortedArrays(int[] A, int[] B){
		int totalLen = A.length + B.length;

		if(totalLen % 2  == 1){
			return findKth(A, 0, B, 0, totalLen / 2 + 1);
		}
		return (
			findKth(A, 0, B, 0, totalLen / 2) + findKth(A, 0, B, 0, totalLen / 2 + 1)
		) / 2.0;


	}


	public int findKth(int[] A, int startPosA, int[] B, int startPosB, int k){
		if(startPosA >= A.length){
			return B[startPosB + k - 1];

		}

		if(startPosB >= B.length){
			return A[startPosA + k - 1];
		}

		if(k == 1){
			return Math.min(A[startPosA], B[startPosB]);
		}

		int valueA;
		int valueB;

		if(startPosA + k / 2 - 1 < A.length){
			valueA = A[startPosA + k / 2 - 1];
		}
		else{
			valueA = Integer.MAX_VALUE;
		}

		if(startPosB + k / 2 - 1 < B.length){
			valueB = B[startPosB + k / 2 - 1];
		}
		else{
			valueB = Integer.MAX_VALUE;
		}


		if(valueA < valueB){
			return findKth(A, startPosA + k / 2, B, startPosB, k - k / 2);
		}
		else{
			return findKth(A, startPosA, B, startPosB + k / 2, k - k / 2);
		}

	}
}