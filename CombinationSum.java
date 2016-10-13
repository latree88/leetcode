import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum{
	public static void main(String argsp[]){

	}


	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(candidates == null){
			return res;
		}

		ArrayList<Integer> path = new ArrayList<Integer>();

		Arrays.sort(candidates);
		helper(candidates, target, path, 0, res);

		return res;

	}



	public void helper(int[] candidates, int target, ArrayList<Integer> path, int index, ArrayList<ArrayList<Integer>> res){

		if(target == 0){
			res.add(new ArrayList<Integer>(path));
			return;

		}

		int pre = -1;
		for(int i = index; i < candidates.length; i++){
			if(candidates[i] > target ){
				break;
			}

			// ??????????????????????????????????
			// if one element is equal to previous candidate then we dont need to 
			// recursively call helper then we have chance to look at same index candidates.length times

			if(pre != -1 && pre == candidates[i]){
				continue;
			}

			path.add(candidates[i]);
			helper(candidates, target - candidates[i], path, i, res);
			path.remove(path.size() - 1);

			pre = candidates[i];
		}


	}


}