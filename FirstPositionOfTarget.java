public class FirstPositionOfTarget{
	public static void main(String args[]){
		FirstPositionOfTarget obj = new FirstPositionOfTarget();

		int [] temp = {1, 2, 3, 3, 4, 5, 10};

		int a = obj.binarySearch(temp, 3);
		System.out.println(a);
	}

	public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0){
        	return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if(target == nums[mid]){
        		int index = mid;
        		while(index >= 1 && nums[index - 1] == nums[mid]){
        			--index;
        		}
        		return index;
        	}
        	else if(target < nums[mid]){
        		end = mid;
        	}
        	else{
        		start = mid;
        	}
        }

        if(target == nums[end]){
        	int index = end;
        	while(index >= 1 && nums[index - 1] == nums[end]){
        		--index;
        	}
        	return index;        	
        }
        else if(target == nums[start]){
        	int index  = start;
        	while(index >= 1 && nums[index - 1] == nums[start]){
        		--index;
        	}
        	return index;
        }
        return -1;


    }

}