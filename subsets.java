// key point:
// s[n] = s[n-1] + [n] + (add n for each previous subsets)

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class subsets{
	public static void main(String args[]){
		subsets obj = new subsets();

		int [] nums = {1,2,3};
		obj.subsets(nums);

	}

	public List<List<Integer>> subsets(int [] nums){
		if(nums == null)
			return null;
		Arrays.sort(nums);


		List<List<Integer>> result  = new ArrayList<>();

		int len = nums.length;
		for(int i = 0; i < len; i++){
			ArrayList<ArrayList<Integer>> temp  = new ArrayList<ArrayList<Integer>>();

			// add all sets from previous result to temp
			for(List<Integer> a : result){
				temp.add(new ArrayList<Integer>(a));
			}

			// add current number to all sets
			for(ArrayList<Integer> a : temp){
				a.add(nums[i]);
			}

			// add single number set to result
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);
			result.addAll(temp);
		}

		result.add(new ArrayList<Integer>());

		return result;

	}


}