public class CopyListWithRandomPointer{

	public static class RandomListNode{
		int label;
		RandomListNode next, random;

		public RandomListNode(int x){
			this.label = x;
			this.next = null;
			this.random = null;
		}

	}

	public static void main(String args[]){

	}

	public RandomListNode copyRandomList(RandomListNode head){
		if(head == null){
			return null;
		}

		RandomListNode copyDummy = new RandomListNode(0);
		copyDummy.next = new RandomListNode(head.label);
		RandomListNode copyCur = copyDummy.next;

		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode cur = head;

		cur = cur.next;

		while(cur != null){
			copyCur.next = new RandomListNode(cur.label);
			copyCur = copyCur.next;
			cur = cur.next;
		}

		copyCur = copyDummy.next;
		cur = dummy.next;

		while(cur != null){
			int index = findIndex(dummy.next, cur.random);
			copyCur.random = findNode(copyDummy.next, index);

			cur = cur.next;
			copyCur = copyCur.next;
		}


		return copyDummy.next;

	}

	public int findIndex(RandomListNode head, RandomListNode source){
		if(head == null){
			return -1;
		}

		int count = 0;
		while(head != null){
			if(head == source){
				return count;
			}
			++count;
			head = head.next;
		}

		return -1;
	}

	public RandomListNode findNode(RandomListNode head,int index){

		if(index == -1){
			return null;
		}

		for(int i = 0; i < index; i++){

			head = head.next;
		}

		return head;
	}



}