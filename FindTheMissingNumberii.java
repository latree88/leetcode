public class FindTheMissingNumberii{
	public static void main(String args[]){
		String temp = "19201234567891011121314151618";

		int rslt = new FindTheMissingNumberii().findMissing2(20, temp);

		System.out.println(rslt);

	}

	public int findMissing2(int n, String str){

		int[] count = new int[10];
		
		// int sum = 0;
		for(int i = 1; i < n + 1; i++){

			int firstDigit = i % 10;
			int secondDigit = i / 10;
			// sum += firstDigit + secondDigit;

			if(secondDigit == 0){
				++count[firstDigit]; 
			}
			else{
				++count[firstDigit];
				++count[secondDigit];
			}

		}

		for(int i = 0; i < str.length(); i++){
			int val = Character.getNumericValue(str.charAt(i));
			// sum -= val;
			--count[val];
		}

		int[] twoDigits = findNumber(count);

		// sum is the sum of first digit and second digit
		if(twoDigits[0]*10 + twoDigits[1] <= n){
			return twoDigits[0]*10 + twoDigits[1];
		}
		else{
			return twoDigits[1]*10 + twoDigits[0];
		}
	}

	public int[] findNumber(int[] source){
		int[] target = new int[2];
		int index = 0;
		for(int i = 0; i < source.length; i++){
			if(source[i] != 0){
				target[index] = i;
				++index;
				if(index > 1){
					return target;
				}
			}
		}

		return target;
	}
}



