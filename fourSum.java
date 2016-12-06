import java.util.*;

public class fourSum{

	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target){
		ArrayList<ArrayList<Integer>> res =  new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);

		for(int i = 0; i < numbers.length - 3; i++){
			if(i != 0 && numbers[i] == numbers[i - 1]){
				continue;
			}

			for(int j = i + 1; j < numbers.length - 2; j++){
				if(j != i + 1 && numbers[j] == numbers[j - 1]){
					continue;
				}

				int left = j + 1;
				int right = numbers.length - 1;
				while(left < right){
					int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
					if(sum < target){
						left++;
					}
					else if(sum > target){
						right--;
					}
					else{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(numbers[i]);
						temp.add(numbers[j]);
						temp.add(numbers[left]);
						temp.add(numbers[right]);
						res.add(temp);
						left++;
						right--;

						while(left < right && numbers[left] == numbers[left -1]){
							left++;
						}
						while(left < right && numbers[right] == numbers[right + 1]){
							right--;
						}
					}
				}
			}
		}
		return res;
	}

}