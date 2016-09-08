public class PalindromPartitioningii{
	public static void main(String args[]){
		PalindromPartitioningii obj = new PalindromPartitioningii();
		Stirng source;

		int rslt = obj.minCut(source);

		System.out.println(rslt);
	}

	public int minCut(String s){
		if(s == null || s.length() == 0){
			return 0;
		}

		int size = s.length();
		int[] cuts = new int[size + 1];
		cuts[0] = 1;


	}


}