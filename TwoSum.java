import java.util.HashMap;

public class TwoSum{
	public static void main(String args[]){
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] rslt = new TwoSum().twoSum(nums, target);

        System.out.println(rslt[0]);
        System.out.println(rslt[1]);

	}

	public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map =  new HashMap<>();
        

        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                int[] res = new int[]{map.get(nums[i]) + 1, i + 1}; 
                
                return res;
            }
            map.put(target - nums[i], i);

        }
        int[] res = {};
        return res;
	}
}