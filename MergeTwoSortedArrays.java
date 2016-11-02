public class MergeTwoSortedArrays{

	public int[] mergeSortedArrays(int[] A, int[] B){
		if(A == null && B == null){
			return null;
		}

		int sizeA = A.length;
		int sizeB = B.length;
		int[] rslt = new int[sizeA + sizeB];
		int i = 0;
		int j = 0;
		int index = 0;

		while(i < A.length && j < B.length){
			if(A[i] < B[j]){
				rslt[index] = A[i];
				i++;
				index++;
			}
			else{
				rslt[index] = B[j];
				j++;
				index++;
			}
		}

		while(i < A.length){
			rslt[index] = A[i];
			i++;
			index++;
		}
		while(j < B.length){
			rslt[index] = B[j];
			j++;
			index++;
		}

		return rslt;

	}
}
















