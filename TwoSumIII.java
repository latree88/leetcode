public class TwoSumIII{

    private ArrayList<Integer> list;
    
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if(list == null){
            list = new ArrayList<>();
        }   
        list.add(number);
        
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            int temp = value - list.get(i);
            if(map.get(list.get(i)) != null){
                return true;
            }    
            map.put(temp, i);
    
            
        }
        
        
        
        return false;
    }

	
}




















