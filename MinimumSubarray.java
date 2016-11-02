import java.util.ArrayList;	

public class MinimumSubarray{


	public static void main(String args[]){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(-1);
		nums.add(-2);
		nums.add(1);

		int rslt = new MinimumSubarray().minSubarray(nums);
		// System.out.println(rslt);
	}



	// when found minimum sum then localMin start to increase when 
	// the value increase
	public int minSubarray(ArrayList<Integer> nums){
		if(nums == null){
			return 0;
		}

		int len = nums.size();
		int min = Integer.MAX_VALUE;
		int[] localMin = new int[len];
		int[] globalMin = new int[len];

		for(int i = 0; i < len; i++){
			if(i == 0){
				globalMin[i] = localMin[i] = nums.get(i);
			}
			else{
				localMin[i] = Math.min(localMin[i - 1] + nums.get(i), nums.get(i));
				globalMin[i] = Math.min(globalMin[i - 1], localMin[i]);
			}

		}
		return globalMin[len - 1];

	}
}



// localMin = 1, -1, -3,    



















