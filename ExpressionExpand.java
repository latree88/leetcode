import java.util.Stack;




public class ExpressionExpand{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}


	public String expressionExpand(String s){
		Stack<String> str = new Stack<String>();
		Stack<Integer> num = new Stack<Integer>();
	
		int number = 0;

		for(char c : s.toCharArray()){
			if(Character.isDigit(c)){
				number = number * 10 + c - '0';
			}
			else if(c == '['){
				str.push("[");
				num.push(number);
				number = 0;
			}
			else if(c == ']'){
				Stack<String> temp = new Stack<String>();

				while(!str.isEmpty()){
					String top = str.pop();
					if(top.equals("[")){
						StringBuffer sb = new StringBuffer();
						StringBuffer rslt = new StringBuffer();

						while(!temp.isEmpty()){
							sb.append(temp.pop());
						}
						int times = num.pop();
						for(int i = 0; i < times; i++){
							rslt.append(sb.toString());
						}

						str.push(rslt.toString());
						break;


					}
					temp.push(top);
				}
			}
			else{
				str.add(String.valueOf(c));
			}


		}

		Stack<String> temp = new Stack<String>();
		StringBuffer rslt =  new StringBuffer();

		while(!str.isEmpty()){
			temp.push(str.pop());
		}

		while(!temp.isEmpty()){
			rslt.append(temp.pop());
		}

		return rslt.toString();


	}	
}

































