import java.util.*;

public class TwoSum{

    public int twoSum2(int[] nums, int target) {
        // Write your code here
    
        if(nums == null || nums.length < 0){
            return 0;
        }
        Arrays.sort(nums);
        
        
        int left = 0;
        int right = nums.length - 1;
        int cnt = 0;
        
        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp > target){
                cnt += right - left;
                right--;
            }
            else{
                left++;
            }
        }
        
        return cnt;
    }

}
























