import java.util.ArrayList;

class Permutation{
	public static void main(String args[]){
		Permutation obj = new Permutation();

		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		temp.add(2);
		ArrayList<ArrayList<Integer>> rslt = obj.permute(temp);
		System.out.println(rslt);

	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> rslt = new ArrayList<ArrayList<Integer>>();
				
		if(nums == null || nums.size() == 0){
			return rslt;
		}

		permuteHelper(rslt, new ArrayList<Integer>(), nums);
		return rslt;
	}

	public void permuteHelper(ArrayList<ArrayList<Integer>> rslt,
							  ArrayList<Integer> subset,
							  ArrayList<Integer> nums){
		if(subset.size() == nums.size()){
			rslt.add(new ArrayList<Integer>(subset));
			return;
		}

		for(int i = 0; i < nums.size(); i++){
			if(subset.contains(nums.get(i))){
				continue;
			}
			subset.add(nums.get(i));
			permuteHelper(rslt, subset, nums);
			subset.remove(subset.size() - 1);
		}
	}

}