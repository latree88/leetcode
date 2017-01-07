
// Heapsort processs !!!!!!!!!!!!!!!
// 
public class Heapify{

	public void siftdown(int[] A, int k){
		while(k < A.length){
			int smallest = k;
			if(k * 2 + 1 < A.length && A[smallest] > A[k * 2 + 1]){
				smallest = k * 2 + 1;
			}
			if(k * 2 + 2 < A.length && A[smallest] > A[k * 2 + 2]){
				smallest = k * 2 + 2;
			}
			if(smallest == k){
				break;
			}

			int temp = A[k];
			A[k] = A[smallest];
			A[smallest] = temp;

			k = smallest;
		}
	}

	public void heapify(int[] A){
		for(int i = A.length / 2; i >= 0; i--){
			siftdown(A, i);
		}
	}
}





























