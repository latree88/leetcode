import java.util.ArrayList;
import java.util.Collections;

class Permutationii{
	public static void main(String args[]){
		Permutationii obj = new Permutationii();

		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		temp.add(2);
		ArrayList<ArrayList<Integer>> rslt = obj.permuteUnique(temp);
		// System.out.println(rslt);

	}

	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> rslt = new ArrayList<ArrayList<Integer>>();
				
		if(nums == null || nums.size() == 0){
			return rslt;
		}
		Collections.sort(nums);

		int[] visit = new int[nums.size()];

		permuteUniqueHelper(rslt, new ArrayList<Integer>(), nums, visit);
		return rslt;
	}

	public void permuteUniqueHelper(ArrayList<ArrayList<Integer>> rslt,
							  ArrayList<Integer> subset,
							  ArrayList<Integer> nums,
							  int[] visit){
		
		if(subset.size() == nums.size()){
			rslt.add(new ArrayList<Integer>(subset));
			return;
		}

		for(int i = 0; i < nums.size(); i++){
			if(visit[i] == 1 || (i != 0 && nums.get(i) == nums.get(i - 1) && visit[i - 1] == 0)){
				continue;
			}
			subset.add(nums.get(i));
			visit[i] = 1;
			// System.out.println("i: " + i);
			// System.out.println(subset);
			permuteUniqueHelper(rslt, subset, nums, visit);
			subset.remove(subset.size() - 1);
			visit[i] = 0;

			// System.out.println("************i: " + i);
			// System.out.println("visit: " + visit[i]);
			// System.out.println(subset);
		}
	}

}