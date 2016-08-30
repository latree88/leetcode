public class SearchA2DMatrix{
	public static void main(String args[]){
		SearchA2DMatrix obj = new SearchA2DMatrix();

		int[][] temp = {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		};

		boolean a = obj.searchMatrix(temp, 7);

		System.out.println(a);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
        	return false;
        }
    
        int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0;
        int end = row * column - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target == matrix[mid / column][mid % column]){
            	return true;
            }
            else if(target < matrix[mid / column][mid % column]){
            	end = mid;
            }
            else{
            	start = mid;
            }
        }    	

        if(target == matrix[start / column][start % column]){
        	return true;
        }
        if(target == matrix[end / column][end % column]){
        	return true;
        }
        return false;
    }
}