public class MergeSort{

	public static void main(String args[]){
		int[] toSort = {-3, 1, 1, -3, 5};

		new MergeSort().sortInteger(toSort);

		for(int i = 0; i < toSort.length; i++){
			System.out.println(toSort[i]);
		}
	}


	public void sortInteger(int[] A){
		int[] temp = new int[A.length];
		mergeSort(A, 0, A.length - 1, temp);
	}

	public void mergeSort(int[] A, int start, int end, int[] temp){
		if(start >=  end){
			return;
		}

		int mid = (start + end) / 2;

		mergeSort(A, start, mid, temp);
		mergeSort(A, mid + 1, end, temp);

		merge(A, start, mid, end, temp);

	}


	public void merge(int[] A, int start, int mid, int end, int[] temp){
		int left = start;
		int right = mid + 1;
		int index = start;



		while(left <=  mid && right <= end){
			if(A[left] <= A[right]){
				temp[index] = A[left];
				++index;
				++left;
			}
			else{
				temp[index] = A[right];
				++index;
				++right;
			}
		}

		while(left <= mid){
			temp[index] = A[left];
			++index;
			++left;
		}

		while(right <= end){
			temp[index] = A[right];
			++index;
			++right;
		}


		for(int i = start; i <= end; i++){
			A[i] = temp[i];
		}


	}



}