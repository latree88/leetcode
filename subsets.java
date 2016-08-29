// key point:
// s[n] = s[n-1] + [n] + (add n for each previous subsets)

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Subsets{
	public static void main(String args[]){
		Subsets obj = new Subsets();

		int [] nums = {1, 2, 3};
		ArrayList<ArrayList<Integer>>  rslt = obj.subsets(nums);

		System.out.println(rslt);

	}

	// non-recursive method

	// public List<List<Integer>> subsets(int [] nums){
	// 	if(nums == null)
	// 		return null;
	// 	Arrays.sort(nums);


	// 	List<List<Integer>> result  = new ArrayList<>();

	// 	int len = nums.length;
	// 	for(int i = 0; i < len; i++){
	// 		ArrayList<ArrayList<Integer>> temp  = new ArrayList<ArrayList<Integer>>();

	// 		// add all sets from previous result to temp
	// 		for(List<Integer> a : result){
	// 			//!!!!!!!!!!!!!!!
	// 			//!!!!!!!!!!!!!!!
	// 			// when add element in ArrayList, you need to make an instance instead of add directly.
	// 			temp.add(new ArrayList<Integer>(a));
	// 		}

	// 		// add current number to all sets
	// 		for(ArrayList<Integer> a : temp){
	// 			a.add(nums[i]);
	// 		}

	// 		// add single number set to result
	// 		ArrayList<Integer> single = new ArrayList<Integer>();
	// 		single.add(nums[i]);
	// 		temp.add(single);
	// 		result.addAll(temp);
	// 	}

	// 	result.add(new ArrayList<Integer>());

	// 	return result;

	// }


	// *******************  key point
	// this is the most important method!!!!!
	// recursion and DFS algorithm 

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return rslt;
        }
        
        Arrays.sort(nums);
        subsetsHelper(rslt, new ArrayList<Integer>(), nums, 0);
        
        return rslt;
    }
    
    public void subsetsHelper(ArrayList<ArrayList<Integer>> rslt,
                              ArrayList<Integer> subset,
                              int[] nums,
                              int myPos
                              ){
        
    
        rslt.add(new ArrayList<Integer>(subset));
        
        for(int i = myPos; i < nums.length; i++){
            subset.add(nums[i]);
            subsetsHelper(rslt, subset, nums, i + 1);
            subset.remove(subset.size() -1);
        }
    }
}
