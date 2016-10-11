import java.util.HashMap;



public class LRUCache{
	public static void main(String args[]){

	}

	public class Node{
		int key;
		int val;
		Node pre;
		Node next;

		public Node(int key, int val){
			this.key = key;
			this.val = val;
			pre = next = null;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head =  new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	public LRUCache(int capacity){
		this.capacity = capacity;
		tail.pre = head;
		head.next = tail;
	}


	public int get(int key){
		if(!map.containsKey(key)){
			return -1;
		}

		Node cur = map.get(key);

		// remove node in doublely linked list

		cur.pre.next = cur.next;
		cur.next.pre = cur.pre;

		// move cur node to the tail

		moveToTail(cur);
		return cur.val;

	}


	public void set(int key, int value){
		
		// key exist in map then update value
		if(get(key) != -1){
			map.get(key).val = value;
			return;
		}

		if(map.size() == capacity){
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.pre = head;
		}

		Node toInsert = new Node(key, value);
		map.put(key, toInsert);
		moveToTail(toInsert);		

		
	}

	public void moveToTail(Node cur){
		cur.pre = tail.pre;
		tail.pre = cur;
		cur.pre.next = cur;
		cur.next = tail;
	}

}
















































