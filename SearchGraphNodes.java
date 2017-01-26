import java.util.*;

public class SearchGraphNodes{

	class UndirectedGraphNode{
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			this.label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}


	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
										  Map<UndirectedGraphNode, Integer> values,
										  UndirectedGraphNode node,
										  int target){

		if(graph == null || graph.size() == 0){
			return null;
		}

		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		queue.offer(node);

		while(!queue.isEmpty()){
			UndirectedGraphNode tempNode = queue.poll();
			for(UndirectedGraphNode oneNode : tempNode.neighbors){
				queue.offer(oneNode);
			}
			if(values.containsKey(tempNode)){
				if(values.get(tempNode) == target){
					return tempNode;
				}
			}
		}
		return null;
		
	}
}


























