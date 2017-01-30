public class TwoSumIV{



    public int[] twoSum(int[] nums, int target) {
        // write your code here
        
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp == target){
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            else if(temp > target){
                right--;
            }
            else{
                left++;
            }
        }
        
        return res;
    }
}

























