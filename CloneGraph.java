import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;



public class CloneGraph{
	public class UndirectedGraphNode{
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		
		public UndirectedGraphNode(int x){
			this.label = x;
			this.neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}


	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){

		if(node == null){
			return node;
		}
		// get all the nodes
		ArrayList<UndirectedGraphNode> nodes = getNodes(node);

		// clone all the nodes, mapping old -> new ndoes
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		for(UndirectedGraphNode n : nodes){
			map.put(n, new UndirectedGraphNode(n.label));
		}

		// copy all the neighbors
		for(UndirectedGraphNode n : nodes){
			UndirectedGraphNode newNode = map.get(n);
			for(UndirectedGraphNode neighbor : n.neighbors){
				UndirectedGraphNode newNeighbor = map.get(neighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}

		return map.get(node);

	}


	public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set  =  new HashSet<>();
		queue.offer(node);
		set.add(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode temp = queue.poll();
			for(UndirectedGraphNode tempNeighbor : temp.neighbors){
				if(!set.contains(tempNeighbor)){
					set.add(tempNeighbor);
					queue.offer(tempNeighbor);
				}
			}
		}

		return new ArrayList<UndirectedGraphNode>(set);
	}
}
































