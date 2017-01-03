import java.util.*;

public class TopKFrequentWords{



	public String[] TopKFrequentWords(String[] words, int k){

	    final HashMap<String, Integer> map = new HashMap<>();
        
        int size = 0;
        for(String oneWord : words){
            if(!map.containsKey(oneWord)){
                map.put(oneWord, 1);
                size++;
            }
            else{
                map.put(oneWord, map.get(oneWord) + 1);
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(size, new Comparator<String>(){
        	public int compare(String a, String b){
        		if(map.get(b) != map.get(a)){
        			return map.get(b) - map.get(a);
        		}
        		return a.compareTo(b);
        	}
        });

        for(String oneKey : map.keySet()){
        	heap.offer(oneKey);
        }


        String[] res = new String[k];
        


        for(int i = 0; i < k; i++){
        	res[i] = heap.poll();
        }

        

        return res;
	}
}























