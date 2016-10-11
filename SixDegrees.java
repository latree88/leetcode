import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


public class SixDegrees{
	public static void main(String args[]){

	}

	public class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x){
			this.label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public int sixDegrees(List<UndirectedGraphNode> graph, 
							UndirectedGraphNode s, 
							UndirectedGraphNode t){

		if(s == t){
			return 0;
		}

		HashMap<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		queue.offer(s);
		visited.put(s, 0);

		while(!queue.isEmpty()){
			UndirectedGraphNode node = queue.poll();
			int step = visited.get(node);
			for(int i = 0; i < node.neighbors.size(); i++){
				if(visited.containsKey(node.neighbors.get(i))){
					continue;
				}
				if(node.neighbors.get(i) == t){
					return step + 1;
				}
				visited.put(node.neighbors.get(i), step + 1);
				queue.add(node.neighbors.get(i));

			}
		}

		return -1;

	}
}












































