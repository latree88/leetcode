import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;



public class TopologicalSorting{


	public class DirectedGraphNode{
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		public DirectedGraphNode(int x){
			this.label = x;
			this.neighbors = new ArrayList<DirectedGraphNode>();

		}
	}


	public static void main(String args[]){

	}


	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){

		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();


		// calculate distance 
		for(DirectedGraphNode node : graph){
			for(DirectedGraphNode neighbor : node.neighbors){
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor) + 1);
				}
				else{
					map.put(neighbor, 1);
				}
			}
		}

		// find the first node
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

		for(DirectedGraphNode node : graph){
			if(!map.containsKey(node)){
				queue.offer(node);
				res.add(node);
			}
		}

		// bfs
		while(!queue.isEmpty()){
			DirectedGraphNode tempNode = queue.poll();
			for(DirectedGraphNode neighbor : tempNode.neighbors){
				map.put(neighbor, map.get(neighbor) - 1);
				if(map.get(neighbor) == 0){
					queue.offer(neighbor);
					res.add(neighbor);
				}
			}
		}

		return res;




	}

}














































