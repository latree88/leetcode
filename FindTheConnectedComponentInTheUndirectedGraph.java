import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;



public class FindTheConnectedComponentInTheUndirectedGraph{

	public class UndirectedGraphNode{
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x){
			this.label = x;
			this.neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}


	public static void main(String args[]){

	}


	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes){
		HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();

		for(UndirectedGraphNode node : nodes){
			visited.put(node, false);
		}


		List<List<Integer>> res = new ArrayList<>();

		for(UndirectedGraphNode node : nodes){
			if(visited.get(node) == false){
				bfs(node, visited, res);
			}
		}

		return res;


	}

	public void bfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, Boolean> visited, List<List<Integer>> res){
		Queue<UndirectedGraphNode> queue  =  new LinkedList<>();
		List<Integer> tempRes = new ArrayList<>();
		visited.put(node, true);
		queue.offer(node);

		while(!queue.isEmpty()){
			UndirectedGraphNode temp = queue.poll();
			tempRes.add(temp.label);
			for(UndirectedGraphNode tempNeighbor : temp.neighbors){
				if(visited.get(tempNeighbor) == false){
					visited.put(tempNeighbor, true);
					queue.offer(tempNeighbor);

				}
			}
		}

		Collections.sort(tempRes);
		res.add(tempRes);

	}

}