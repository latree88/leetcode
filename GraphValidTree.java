import java.util.*;

public class GraphValidTree {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        
        if (n == 0) {
            return false;
        }
        
        if (edges.length != n - 1) {
            return false;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();



        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<Integer>());

        }

        for(int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<Integer>(); 
        
        queue.add(0);
        set.add(0);
        
        int count = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            ++count;
            for(Integer one : map.get(temp)){
                if(set.contains(one)){
                    continue;
                }
                queue.add(one);
                set.add(one);
            }
        }

        return n == count;
    }
}



























