
// key point:
// binary search question
// binary search method can be applied in any question that related to find a number in a range.

class Sqrt{
	public static void main(String args[]){
		Sqrt obj = new Sqrt();
	}

	public int mysqrt(int x){
		long start =1;
		long end = x;

		while(start + 1 < end){
			long mid = start + (end - start)/2;
			if(mid * mid <= x){
				start = mid;
			}
			else{
				end = mid;
			}
		}

		if(end * end <= x){
			return (int) end;
		}

		return (int) start;

	}
}