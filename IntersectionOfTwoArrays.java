import java.util.ArrayList;

class IntersectionOfTwoArrays {

	public static void main(String args[]){
		IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();

	}

	public int[] Intersection(int[] nums1, int[] nums2){
		if(nums1 == null || nums2 == null){
			return null;
		}

		ArrayList<Integer> rsltHolder = new ArrayList<Integer>();

		for(int i = 0; i < nums1.length; i++){
			for(int j =0; j < nums2.length; j++){
				if(nums1[i] == nums2[j]){
					if(!rsltHolder.contains(nums1[i])){
						rsltHolder.add(nums1[i]);
					}
				}
			}
		}

		int[] rslt = new int[rsltHolder.size()];

		for(int i = 0; i < rslt.length; i++){
			rslt[i] = rsltHolder.get(i);
		}

		return rslt;
	}
}