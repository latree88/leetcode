import java.util.*;

public class SmallestRectangleEnclosingBlackPixels{


    public int minArea(char[][] image, int x, int y) {
        // Write your code here
		int m = image.length;
		int n = image[0].length;
		int mid;

		int start = y;
		int end = n - 1;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(checkCol(image, mid)){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		int right;
		if(checkCol(image, end)){
			right = end;
		}
		else{
			right = start;
		}

		start = 0;
		end = y;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(checkCol(image, mid)){
				end = mid;
			}
			else{
				start = mid;
			}
		}
		int left;
		if(checkCol(image, start)){
			left = start;
		}
		else{
			left = end;
		}

		start = x;
		end = m - 1;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(checkRow(image, mid)){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		int down;
		if(checkRow(image, end)){
			down = end;
		}
		else{
			down = start;
		}



		start = 0;
		end = x;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(checkRow(image, mid)){
				end = mid;
			}
			else{
				start = mid;
			}
		}
		int up;
		if(checkRow(image, start)){
			up = start;
		}
		else{
			up = end;
		}
    

		return (Math.abs(right - left) + 1) * (Math.abs(down - up) + 1);
    }
    
    private boolean checkCol(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return true;
            }
        }
        return false;
    } 
}













