class SortLettersByCase{

	public static void main(String[] args){

	}
	public void sortLetters(char[] chars){
		int left =  0;
		int right = chars.length - 1;

		while(left <= right){
			while(left <= right && Character.isLowerCase(chars[left])){
				left++;
			}
			while(left <= right && Character.isUpperCase(chars[right])){
				right--;
			}

			if(left <= right){
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
		}

		return;
	}

}















