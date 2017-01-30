import java.util.*;

public class TwoSumV{




	public int twoSum5(int[] nums, int target) {
        // Write your code here
        
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int left = 0; 
        int right = nums.length - 1;
        
        int count = 0;
        
        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp > target){
                right--;
            }
            else{
                count += right - left;
                left++;
            }
        }
        
        return count;
        
    }
}
























