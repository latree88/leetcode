import java.util.*;

public class SequenceReconstruction{

	public boolean sequenceReconstruction(int[] org, int[][] seqs){
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();

		for(int num : org){
			map.put(num, new HashSet<Integer>());
			indegree.put(num, 0);
		}

		int n = org.length;
		int count  = 0;

		for(int i = 0; i < seqs.length; i++){
			count += seqs[i].length;
			if(seqs[i].length >= 1 && (seqs[i][0] <= 0 || seqs[i][0] > n))
				return false;

			for(int j = 1; j < seqs[i].length; j++){
				if(seqs[i][j] <= 0 || seqs[i][j] > n)
					return false
				// avoid to add same elemnt into set repeatly
				if(map.get(seqs[i][j - 1]).add(seqs[i][j]))
					indegree.put(seqs[i][j], indegree.get(seqs[i][j]) + 1);
			}
		}

		// case: [1], []
		if(count < n){
			return false;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int key : indegree.keySet()){
			if(indegree.get(key) == 0){
				queue.add(key);
			}
		}

		int cnt = 0;

		//  only one element in the queue at a time
		//  since seqs order can not be changed 
		while(queue.size() == 1){
			int temp = queue.poll();
			for(int one : map.get(temp)){
				indegree.put(one, indegree.get(one) - 1);
				if(indegree.get(one) == 0){
					queue.add(one);
				}
			}
			cnt++;
		}

		return cnt == org.length;

	}



}






















