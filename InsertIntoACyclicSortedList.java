public class InsertIntoACyclicSortedList{

	 public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
		    val = x;
		    next = null;
		}
	 }
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if(node == null){
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        
        ListNode p = node;
        ListNode pre = null;
        
        do{
            pre = p;
            p = p.next;
            
            if(p.val >= x && pre.val <= x){
                break;
            }
            if(pre.val > p.val && (x > pre.val || x < p.val)){
                break;
            }
        }while( p != node);
        ListNode temp = new ListNode(x);
        temp.next = p;
        pre.next = temp;
        return temp;
    }
}