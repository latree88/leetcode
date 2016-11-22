import java.util.*;
public class PopulatingNextRightPointersInEachNode{

	public class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;
		public TreeLinkNode(int x){
			this.val = x;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root){
		if(root == null){
			return;
		}
		
		Queue<TreeLinkNode> queue = new LinkedList<>();
		Queue<TreeLinkNode> layer = new LinkedList<>();
		
		queue.offer(root);
		
		
		while(!queue.isEmpty()){
			
			while(!queue.isEmpty()){
				layer.offer(queue.poll());
			}
			
			TreeLinkNode cur = layer.poll();
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
			
			while(!layer.isEmpty()){
				cur.next = layer.poll();
				cur =  cur.next;
				
				if(cur.left != null)
					queue.offer(cur.left);
				if(cur.right != null)
					queue.offer(cur.right);
			}
			
			cur.next = null;
			
			
			
			
		}
	}
}





















