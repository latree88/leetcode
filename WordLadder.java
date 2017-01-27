public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
      
    public class WordNode{
        String word;
        int step;
        
        public WordNode(String tempWord, int numSteps){
            word = tempWord;
            step = numSteps;
        }
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(end);
        
        Queue<WordNode> queue = new LinkedList<>();
        queue.offer(new WordNode(start, 1));
        
        
        while(!queue.isEmpty()){
            WordNode temp = queue.poll();
            if(temp.word.equals(end)){
                return temp.step;
            }
            
            char[] arr = temp.word.toCharArray();
            for(int i = 0; i < arr.length; i++){
                char save = arr[i];
                for(char a ='a'; a < 'z'; a++){
                    if(arr[i] != a){
                        arr[i] = a;
                    }
                    String changedArr = new String(arr);
                    if(dict.contains(changedArr)){
                        queue.add(new WordNode(changedArr, temp.step + 1));
                        dict.remove(changedArr);
                    }
                }
                arr[i] = save;
            }
        }
        return 0;
    }
}




















