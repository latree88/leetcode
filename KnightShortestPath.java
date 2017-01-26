import java.util.*;

public class KnightShortestPath{

	public class Point{
		int x, y;
		public Point(){ x = 0; y = 0;}
		public Point(int a, int b){
			x = a;
			y = b;
		}
	}

	public int shortestPath(boolean[][] grid, Point source, Point destination){
		int n =  grid.length;
		int m = grid[0].length;

		int[][] record = new int[n][m];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				record[i][j] = Integer.MAX_VALUE;
			}
		}

		record[source.x][source.y] = 0;

		Queue<Point> queue = new LinkedList<>();

		queue.offer(source);

		int d[][] = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
		
		while(!queue.isEmpty()){
			Point cur = queue.poll();	

			for(int i = 0; i < 8; i++){
				int x = cur.x + d[i][0];
				int y = cur.y + d[i][1];

				if(x >= 0 && x < n && y >= 0 && y < m && !grid[x][y] &&
					record[cur.x][cur.y] + 1 < record[x][y]){
					record[x][y] = record[cur.x][cur.y] + 1;
					queue.add(new Point(x, y));
				}
			}
		}		

		if(record[destination.x][destination.y] == Integer.MAX_VALUE)
			return -1;
		return record[destination.x][destination.y];
	}
}






















