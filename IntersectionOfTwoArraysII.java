import java.util.ArrayList;
import java.util.HashMap;


// key point:
// use map, key is the int number in source array, value is the number of times shows for this specific number
class IntersectionOfTwoArraysII {

	public static void main(String args[]){
		IntersectionOfTwoArraysII obj = new IntersectionOfTwoArraysII();

	}

	public int[] Intersection(int[] nums1, int[] nums2){
		HashMap<Integer, Integer> rsltHolder = new HashMap<Integer, Integer>();
		ArrayList<Integer> arry = new ArrayList<Integer>();
		for(int temp : nums1){
			if(rsltHolder.containsKey(temp)){
				rsltHolder.put(temp, rsltHolder.get(temp) +1);
			}
			else{
				rsltHolder.put(temp, 1);
			}
		}

		for(int temp : nums2){
			if(rsltHolder.containsKey(temp) && rsltHolder.get(temp) > 0){
					arry.add(temp);
					rsltHolder.put(temp, rsltHolder.get(temp) -1);
				
			}
		}

		int[] rslt = new int[arry.size()];

		for(int i = 0; i < rslt.length; i++){
			rslt[i] = arry.get(i);
		}

		return rslt;	
	}
}