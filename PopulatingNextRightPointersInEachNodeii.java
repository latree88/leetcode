import java.util.*;

public class PopulatingNextRightPointersInEachNodeii{
	public class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x){
			this.val = x;
		
		}
	}

	public static void main(String[] args){

	}

	public void connect(TreeLinkNode root){
		if(root == null){
			return;
		}

		Queue<TreeLinkNode> queue = new LinkedList<>();
		Queue<Integer> depth = new LinkedList<>();

		queue.offer(root);
		depth.offer(1);

		while(!queue.isEmpty()){
			TreeLinkNode tempNode = queue.poll();
			Integer tempDepth = depth.poll();


			if(queue.isEmpty()){
				tempNode.next = null;
			}
			else if(tempDepth < depth.peek()){
				tempNode.next = null;
			}
			else{
				tempNode.next = queue.peek();
			}

			if(tempNode.left != null){
				queue.offer(tempNode.left);
				depth.offer(tempDepth + 1);
			}

			if(tempNode.right != null){
				queue.offer(tempNode.right);
				depth.offer(tempDepth + 1);
			}

		}

	}


}



























