import java.util.ArrayList;

public class UglyNumberii{
	public static void main(String args[]){

	}

	public int nthUglyNumber(int n){
		if(n <= 0){
			return 0;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);

		int p2 = 0;
		int p3 = 0;
		int p5 = 0;

		while(list.size() < n){
			int m2 = list.get(p2) * 2;
			int m3 = list.get(p3) * 3;
			int m5 = list.get(p5) * 5;

			int min = Math.min(m2, Math.min(m3,m5));

			list.add(min);

			if(min == m2){
				p2++;
			}
			if(min == m3){
				p3++;
			}
			if(min == m5){
				p5++;
			}
		}

		return list.get(list.size() - 1);

	}
}