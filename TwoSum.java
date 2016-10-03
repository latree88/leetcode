public class TwoSum{
	public static void main(String args[]){

	}

	public int[] twoSum(int[] nums, int target){
		for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int addResult = nums[i] + nums[j];
                if(addResult == target){
                    int index1 = i + 1;
                    int index2 = j + 1;
                    int [] result = {index1, index2};
                    return result;
                }
            }
        }
        return null;
	}
}