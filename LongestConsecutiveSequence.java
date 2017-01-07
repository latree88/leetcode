import java.util.*;


public class LongestConsecutiveSequence{

	public int longestConsecutive(int[] num){
		HashSet<Integer> set =  new HashSet<Integer>();
		for(int i = 0; i < num.length; i++){
			set.add(num[i]);
		}

		int longest = 0;

		for(int i = 0; i < num.length; i++){
			int down = num[i] - 1;
			while(set.contains(down)){
				set.remove(down);
				down--;
			}

			int up = num[i] + 1;
			while(set.contains(up)){
				set.remove(up);
				up++;

			}

			longest = Math.max(longest, up - down - 1);
		}

		return longest;
	}
}

















