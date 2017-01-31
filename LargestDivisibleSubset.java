import java.util.*;

public class LargestDivisibleSubset{

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null||nums.length==0)
            return res;
            
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        
        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);
        
        int max = 0;
        int maxIndex = -1;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
            	//找到一个可以被nums[i] 整除的 j 那么如果出现另外一个，可以忽略掉
            	// 因为是两两相取mod
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                
                }
            }
            
            if(max < dp[i]){
                max = dp[i];
                maxIndex = i;
            }
        }
        
        int i = maxIndex;
        
        while(i >= 0){
            res.add(nums[i]);
            i = index[i];
        }
        
        return res;
        
    }	
}














