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

			if(i == nums.length -1 || nums[i] != nums[i+1] || pre.size() ==0){
				pre = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < result.size(); j++){
					pre.add(new ArrayList<Integer>(result.get(j)));
				}
			}

			for(ArrayList<Integer> temp : pre){
				temp.add(0, nums[i]);
			}

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