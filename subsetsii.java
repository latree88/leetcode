
// key point for this problem:
// 1. sort array and iterate in back order 
// 2. have prev list to help to hold previous iteration sets

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class subsetsii{
	public static void main(String arg[]){
		subsetsii obj = new subsetsii();

	}

	public List<List<Integer>> subsetsWithDup(int[] nums){
		if(nums == null)
			return null;

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();

		for(int i = nums.length-1; i >= 0; i--){

			// reset the prev and add all sets from result to prev
			if(i == nums.length -1 || nums[i] != nums[i+1] || pre.size() ==0){
				pre = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < result.size(); j++){
					pre.add(new ArrayList<Integer>(result.get(j)));
				}
			}

			// add current number to each set in prev
			for(ArrayList<Integer> temp : pre){
				temp.add(0, nums[i]);
			}

			// add single number set only is not duplicate
			if(i == nums.length -1 || nums[i] != nums[i+1]){
				ArrayList<Integer> temp  = new ArrayList<Integer>();
				temp.add(nums[i]);
				pre.add(temp);
			}

			for(ArrayList<Integer> temp : pre){
				result.add(new ArrayList<Integer>(temp));
			}
		}

		result.add(new ArrayList<Integer>());

		return result;


	}

}