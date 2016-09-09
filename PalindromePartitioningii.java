public class PalindromePartitioningii{
	public static void main(String args[]){
		PalindromePartitioningii obj = new PalindromePartitioningii();
		String source = "aab";

		int rslt = obj.minCut(source);

		System.out.println(rslt);
	}

	public int minCut(String s){
		if(s == null || s.length() == 0){
			return 0;
		}

		int size = s.length();
		int[] cuts = new int[size + 1];
		boolean[][] palindrome = new boolean[size][size];

		for(int i = 0; i < size; i++){
			cuts[i] = size - i; 
		}

		for(int i = size - 1; i >= 0; --i){
			for(int j = i; j < size; ++j){
				if((s.charAt(i) == s.charAt(j) && (j - i < 2)) 
					|| (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1])){

					palindrome[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
				}
			}
		}

		return cuts[0] - 1;

	}


}