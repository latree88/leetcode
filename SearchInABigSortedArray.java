import java.util.ArrayList;


//Key point:
// target <= mid, move end will get first index of target number
// target >= mid, move start will get last index of target number
public class SearchInABigSortedArray{
	public static void main(String args[]){
		SearchInABigSortedArray obj = new SearchInABigSortedArray();

		int[] data = {1,1,1,1,2,2,3,3,3,4,4,4,5,5,5,5,5,5,5,6,6,6,
			          6,6,6,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,
			          10,10,10,10,11,11,11,11,12,12,12,13,13,13,13,
			          13,14,14,14,14,14,15,15,15,15,15,15,15,16,16,
			          16,16,16,16,16,16,16,17,17,17,17,17,17,17,18,
			          18,19,19,19,19,20,20,20,20,20,20,20,20,20};
		ArrayList<Integer> temp = new ArrayList<>();

		for(int i = 0; i < data.length; i++){
			temp.add(data[i]);
		}

		int rslt = obj.searchBigSortedArray(temp, 2);
		System.out.println(rslt);
	}

    public int searchBigSortedArray(ArrayList<Integer> reader, int target) {
        // write your code here
        int index = 1;
        while(reader.get(index - 1) < target){
        	index = index * 2;
        }

        int start = 0;
        int end = index - 1;

        while(start + 1 < end){
        	int mid =  start + (end - start) / 2;
        	if(target > reader.get(mid)){
        		start = mid;
        	}
        	else{
        		end = mid;
        	}
        }
        if(target == reader.get(end)){        	
        	return end;
        }
        if(target == reader.get(start)){
        	return start;
        }
        return -1;
    }
}