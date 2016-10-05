import java.util.Comparator;
import java.util.Arrays;

public class SubarraySumClosest{

	class Pair {
	    int sum;
	    int index;
	    public Pair(int s, int i) {
	        sum = s;
	        index = i;
	    }
	}
	public static void main(String args[]){
		int[] nums = {-3, 1, 1, -3, 5};

		int[] rslt = new SubarraySumClosest().subarraySumClosest(nums);
	
		for(int i = 0; i < rslt.length; i++){
			System.out.println(rslt[i]);
		}
	}


	public int[] subarraySumClosest(int[] nums){
		int[] res = new int[2];
		if(nums == null || nums.length == 0){
			return res;
		}

		if(nums.length == 1){
			res[0] = res[1] = 0;
		}

		int len = nums.length;
		Pair[] sum = new Pair[len + 1]; 
		sum[0] = new Pair(0,0);
		int prev = 0;
		
		for(int i = 1; i <= len; i++){
			sum[i] = new Pair(prev + nums[i - 1], i);
			prev = sum[i].sum;
		}

		Arrays.sort(sum, new Comparator<Pair>(){
			public int compare(Pair a, Pair b){
				return a.sum - b.sum;
			}
		});

		int ans = Integer.MAX_VALUE;
		for(int i = 1; i <= len; i++){
			if(ans > sum[i].sum - sum[i - 1].sum){
				ans = sum[i].sum - sum[i - 1].sum;
				int[] temp = new int[]{sum[i].index - 1, sum[i - 1].index - 1};
				Arrays.sort(temp);
				res[0] = temp[0] + 1;
				res[1] = temp[1];  

			}
		}
		return res;
	}


}



















