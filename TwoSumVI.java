public class TwoSumVI{
	
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> degree = new HashSet<>();
        
        
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.get(nums[i]) != null){
                if(!degree.contains(nums[i])){
                    count++;    
                    degree.add(temp);
                    degree.add(nums[i]);
                }
                
            }
            
            map.put(temp, i);
        }
        return count;
    }	
	
}











