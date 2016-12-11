import java.util.*;

public class ImplementQueueByLinkedListII{
	public static void main(String[] args){
		ImplementQueueByLinkedListII obj = new ImplementQueueByLinkedListII();
		obj.push_front(1);
		obj.push_back(2);
		System.out.println(obj.pop_back());

		System.out.println(obj.pop_back());

		// System.out.println("&&&&&&&&&&&&&&&");
		// obj.display();
		// System.out.println("&&&&&&&&&&&&&&&");

		obj.push_back(3);
		obj.push_back(4);
		System.out.println(obj.pop_front());
		System.out.println(obj.pop_front());
	}

	public class Node{
		int val;
		Node next;
		public Node(int data){
			this.val = data;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;


	public ImplementQueueByLinkedListII(){
		this.head = null;
		this.tail = null;
	
	}

	public void push_front(int item){
		if(head == null){
			head = new Node(item);
			tail = head;
		}
		else{
			Node temp = new Node(item);
			temp.next = head;
			head =  temp;			
		}

	}

	public void push_back(int item){
		if(tail == null){
			tail = new Node(item);
			head = tail;
		}
		else{
			tail.next = new Node(item);
			tail = tail.next;
		}

	}

	public int pop_front(){
		if(head == null){
			return -1;
		}
		else{
			int ret = head.val;
			if(head == tail){
				head = tail = null;
				return ret;
			}
			else{
				head = head.next;
				return ret;
			}
		}

	}

	public int pop_back(){
		if(tail == null){
			return -1;
		}
		else{
			int ret = tail.val;
			if(head == tail){
				head = tail = null;
				return ret;
			}
			else{
				Node cur = head;
				while(cur.next != tail){
					cur = cur.next;
				}
				tail = cur;
				tail.next = null;
				return ret;				
			}

		}

	}

	public void display(){
		Node cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}










































