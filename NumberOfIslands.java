import java.util.*;

public NumberOfIslands{

	public int numIslands(boolean[][] grid){
		int count = 0;

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j]){
					bfs(grid, i, j);
					count++;	
				}
			}
		}

		return count;
	}

	public void bfs(boolean[][] grid, int x, int y){
		grid[x][y] = false;

		int n = grid.length;
		int m = grid[0].length;

		Queue<Integer> queue = new LinkedList<>();
		int code = x * m + y;
		queue.offer(code);

		while(!queue.isEmpty()){
			int decode = queue.poll();
			int i = decode / m;
			int j = decode % m;

			if(i > 0 && grid[i - 1][j]){
				queue.offer((i - 1) * m + j);
				grid[i - 1][j] = false;
			}

			if(j > 0 && grid[i][j - 1]){
				queue.offer(i * m + j - 1);
				grid[i][j - 1] = false;
			}


			if(i < n - 1 && grid[i + 1][j]){
				queue.offer((i + 1) * m + j);
				grid[i + 1][j] = false;
			}


			if(j < m - 1 && grid[i][j + 1]){
				queue.offer(i * m + j + 1);
				grid[i][j + 1] = false;
			}
		}
	}
}























