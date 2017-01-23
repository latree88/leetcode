public class Sqrtx{


	public int sqrt(int x){
		int start = 1;
		int end = x;

		while(start + 1 < end){
			int mid = start + (end - start) / 2;

			if(mid * mid <= x){
				start = mid;
			}
			else{
				end = mid;
			}

		}

		if(end * end <= x){
			return end;
		}

		return start;

	}
}



































