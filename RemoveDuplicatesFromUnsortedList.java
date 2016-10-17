import java.util.HashSet;


public class RemoveDuplicatesFromUnsortedList{


	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int va){
			this.val = val;
			this.next = null;
		}
	}


	public ListNode removeDuplicates(ListNode head){
		HashSet<Integer> set =  new HashSet<Integer>();

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode cur = dummy;

		while(cur.next != null){
			if(set.contains(cur.next.val)){
				cur.next = cur.next.next;
			}
			else{
				set.add(cur.next.val);
				cur = cur.next;
			}
		}

		return dummy.next;
	}

}





































