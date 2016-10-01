import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum{
	public static void main(String args[]){
		int[] source = {-2, 1, 2, -3, 4};

		ArrayList<Integer> rslt = new SubarraySum().subarraySum(source);

		System.out.println(rslt);
	}

	// special feature for sum numbers which include negative and positive numbers
	// if the sum of a range is 0, which means it will back to the start point
	// it make sense when you draw a chart 
	// !!!!!!!!!!!!!!!!!!!
	public ArrayList<Integer> subarraySum(int[] nums){
		if(nums == null){
			return null;
		}

		ArrayList<Integer> rslt = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, -1);

		int len = nums.length;
		int sum = 0;
		for(int i = 0; i < len; i++){
			sum += nums[i];
			if(map.containsKey(sum)){
				rslt.add(map.get(sum) + 1);
				rslt.add(i);
				return rslt;
			}

			map.put(sum, i);

		}



		return rslt;
	}

}