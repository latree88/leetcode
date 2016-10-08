public class Rehashing{
	class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]){


	}

	public ListNode[] rehashing(ListNode[] hashTable){
		if(hashTable.length <= 0){
			return hashTable;
		}
		int capacity = hashTable.length;
		int newCapacity = capacity * 2;
		ListNode[] newTable = new ListNode[newCapacity];

		for(int i = 0; i < capacity; i++){
			if(hashTable[i] != null){
				while(hashTable[i] != null){
					int index =  hashcode(hashTable[i].val, newCapacity);
					if(newTable[index] == null){
						newTable[index] = new ListNode(hashTable[i].val);
					}
					else{
	                    ListNode dummy = newTable[index];
	                    while (dummy.next != null) {
	                        dummy = dummy.next;
	                    }
	                    dummy.next = new ListNode(hashTable[i].val);
					}


					hashTable[i] = hashTable[i].next;
				}
			}
		}

		return newTable;

	}

	public int hashcode(int key, int capacity){
		return (key % capacity + capacity) % capacity;
	}


}