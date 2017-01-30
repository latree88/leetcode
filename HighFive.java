import java.util.*;

public class HighFive{

	class Record {
	    public int id, score;
	    public Record(int id, int score){
	        this.id = id;
	        this.score = score;
	    }
	}

    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        HashMap<Integer, Double> res = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> studentTopFive = new HashMap<>();
        
        for(Record oneRecord : results){
            if(!studentTopFive.containsKey(oneRecord.id)){
                PriorityQueue<Integer> tempHeap = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return b - a;
                    }
                });
                
                tempHeap.offer(oneRecord.score);
                studentTopFive.put(oneRecord.id, tempHeap);
            }
            else{
                studentTopFive.get(oneRecord.id).add(oneRecord.score);   
            }
        }
        
        for(Integer tempId : studentTopFive.keySet()){
            Double ave = 0.0;
            
            for(int i = 0; i < 5; i++){
                ave += studentTopFive.get(tempId).poll();
            }
            
            res.put(tempId, ave / 5);
        }
        
        return res;
    }	
}












