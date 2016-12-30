import java.util.*;


public class TopKLargestNumbersII{

	private Queue<Integer> minHeap;
	private int maxSize;

	public TopKLargestNumbersII(int k){
		minHeap = new PriorityQueue<>();
		maxSize = k;
	}

	public void add(int num){
		if(minHeap.size() < maxSize){
			minHeap.offer(num);
			return;
		}
		if(num > minHeap.peek()){
			minHeap.poll();
			minHeap.offer(num);
		}

	}

	public List<Integer> topk(){
		List<Integer> res = new ArrayList<>();

		Iterator iter = minHeap.iterator();
		while(iter.hasNext()){
			res.add((Integer)iter.next());
		}

		Collections.sort(res, Collections.reverseOrder());

		return res;


	}
}










