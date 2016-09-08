import java.util.Set;
import java.util.HashSet;


public class WordBreak{
	public static void main(String args[]){
		WordBreak obj = new WordBreak();
		String source = "lintcode";
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");

		boolean rslt = obj.wordBreak(source, dict);

		if(rslt){
			System.out.println("1");
		}
		else{
			System.out.println("0");
		}

	}

	public boolean wordBreak(String s, Set<String> dict){

		int size = s.length();
		boolean[] dp = new boolean[size + 1];
		dp[0] = true;

		for(int i = 0; i < size; i++){
			if(!dp[i]){
				continue;
			}
			for(String dictWord : dict){
				int len = dictWord.length();
				int end = i + len;
				if(end > size){
					continue;
				}
				if(dp[end]){
					continue;
				}
				if(s.substring(i, end).equals(dictWord)){
					dp[end] = true;
				}
			}
		}

		return dp[size];

	}
}