public class FirstBadVersion{
	public static void main(String args[]){
		FirstBadVersion obj = new FirstBadVersion();

	}

	public int findFirstBadVersion(int n){
		if(n == 1){
			return 1;
		}

		int start = 1;
		int end = n;
		while(start + 1 < end){
			int mid = (start + end) / 2;
			if(SVNRepo.isBadVersion(mid)){
				end = mid;
			}
			else{
				start = mid;
			}
		}

		if(SVNRepo.isBadVersion(start) == false){
			return end;
		}
		else{
			return start;
		}
	}

}