import java.util.ArrayList;
import java.util.List;



public class PalindromePartitioning{
	public static void main(String args[]){
		String s = "aab";
		ArrayList<ArrayList<String>> res = new PalindromePartitioning().partition(s);

		for(int i = 0 ; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j));
				System.out.print(",  ");
			}
			System.out.println(" ");

		}
	}

	public ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(s == null){
			return res;
		}

		ArrayList<String> path = new ArrayList<String>();

		helper(s, path, 0, res);
		return res;

 	}
 

	public boolean isPalindrom(String s){
		int start = 0;
		int end = s.length() - 1;

		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			++start;
			--end;
		}

		return true;
	}

	public void helper(String s, ArrayList<String> path, int pos, ArrayList<ArrayList<String>> res){
		if(pos == s.length()){
			res.add(new ArrayList<String>(path));
			return;
		}

		for(int i = pos; i < s.length(); i++){
			String temp = s.substring(pos, i + 1);
			if(!isPalindrom(temp)){
				continue;
			}

			path.add(temp);
			helper(s, path, i + 1, res);

			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// last round result left in the path list, it duplicates when adding to res if don't remove it from path.
			
			path.remove(path.size() - 1);
			
		}


	}
}























