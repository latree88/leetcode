public class SortColorsii{



	public void sortColors2(int[] colors, int k){
		int count = 0;
		int start = 0;
		int end  = colors.length - 1;

		while(count < k){
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;


			for(int i = start; i <= end; i++){
				min = Math.min(min, colors[i]);
				max = Math.max(max, colors[i]);

			}

			int left = start;
			int right = end;
			int cur = left;
			while(cur <= right){
				if(colors[cur] == min){
					swap(left, cur, colors);
					cur++;
					left++;
				}
				else if(colors[cur] > min && colors[cur] < max){
					cur++;
				}
				else{
					swap(cur, right, colors);
					right--;
				}
			}

			count += 2;
			start = left;
			end = right;
		}

	}

	public void swap(int left, int right, int[] colors){
		int temp = colors[left];
		colors[left] = colors[right];
		colors[right] = temp;
	}
}


























