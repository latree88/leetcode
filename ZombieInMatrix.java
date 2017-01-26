import java.util.*;

public class ZombieInMatrix{

	public static void main(String[] args){
		int[][] grid = {
				  {0, 1, 2, 0, 0},
				  {1, 0, 0, 2, 1},
				  {0, 1, 0, 0, 0}
			   };

		ZombieInMatrix obj = new ZombieInMatrix();
		int res = obj.zombie(grid);
		System.out.println(res);
	}

	public class Node{
		int x, y;
		int step;

		public Node(){}
		public Node(int x, int y, int step){
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

 	int[] dx = {-1, 1, 0, 0};
 	int[] dy = {0, 0, -1, 1};

    public int zombie(int[][] grid) {
        // Write your code here
    	int sumZombie = 0;
    	int sumWall = 0;

    	int n = grid.length;
    	int m = grid[0].length;

    	Queue<Node> qzombie = new LinkedList<Node>();

    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < m; j++){
    			if(grid[i][j] == 1){
    				qzombie.offer(new Node(i, j, 0));
    				sumZombie++;
    			}

    			if(grid[i][j] == 2){
    				sumWall++;
    			}
    		}
    	}


    	int step = 0;

    	while(!qzombie.isEmpty()){
    		Node p = qzombie.poll();
    		for(int i = 0; i < 4; i++){
    			int x = p.x + dx[i];
    			int y = p.y + dy[i];

    			if(x < 0 || x >= n || y < 0 || y >= m){
    				continue;
    			}
    			if(grid[x][y] == 0){
    				grid[x][y] = 1;
    				sumZombie++;
    				qzombie.offer(new Node(x, y, p.step +1));
    			}
    		}

    		if(qzombie.peek() == null){
    			step = p.step;
    		}
    	}

    	if(sumZombie + sumWall != n * m){
    		return -1;
    	}
    	else{
    		return step;
    	}
    }	
}






























