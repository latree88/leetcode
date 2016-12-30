public class ImplementQueueByLinkedList{

	private List<Integer> list;

	public ImplementQueueByLinkedList(){
		list = new ArrayList<>();
	}


	public void enqueue(int item){
		list.add(item);
	}

	public int dequeue(){
		int temp = list.get(0);
		list.remove(0);

		return temp;
	}

}


