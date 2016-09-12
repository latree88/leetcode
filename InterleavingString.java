public class InterleavingString{
	

	public static void main(String args[]){
		InterleavingString obj = new InterleavingString();

		String source1 = "";
		String source2 = "";
		String target = "";

		boolean rslt = obj.isInterleave(source1, source2, target);

		if(rslt){
			System.out.println("1");
		}
		else{
			System.out.println("0");
		}


	}

	public boolean isInterleave(String s1, String s2, String s3){

		if(s3.length() != s1.length() + s2.length()){
			return false;
		}
		int row = s1.length();
		int col = s2.length();

		boolean[][] interleave = new boolean[row + 1][col + 1];
		interleave[0][0] = true;

		for (int i = 1; i < row + 1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
			interleave[i][0] = true;
		}

		for(int i = 1; i < col + 1 && s2.charAt(i - 1) == s3.charAt(i - 1); i++){
			interleave[0][i] = true;
		}

		for (int i = 1; i < row + 1; i++ ) {
			for (int j = 1; j < col + 1; j++) {
				char temp = s3.charAt(i + j - 1);
				if(temp == s1.charAt(i - 1) && interleave[i - 1][j]){
					interleave[i][j] = true;
				}
				if(temp == s2.charAt(j - 1) && interleave[i][j - 1]){
					interleave[i][j] = true;
				}
			}
		}

		return interleave[row][col];

	}


}