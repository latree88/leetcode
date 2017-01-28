public class windowSum{
    public int[] winSum(int[] nums, int k) {
        // write your code here
        
        int len = nums.length - k + 1;
        int sum = 0;
        int[] res = new int[len];
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        res[0] = sum;
        
        int head = 0;
        int tail = k-1;
        
        for(int i = 1; i < len; i++){
            sum = sum - nums[head] + nums[tail+1];
            head++;
            tail++;    
            
            res[i] = sum;
        }
        
        return res;
    }
}
























