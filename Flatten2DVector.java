public class Flatten2DVector{

	private ArrayList list;
    private int i = 0;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        list = new ArrayList<>();
        for(int i = 0; i < vec2d.size(); i++){
            for(int j = 0; j < vec2d.get(i).size(); j++){
                list.add(vec2d.get(i).get(j));
            }
        }
        
    }

    @Override
    public Integer next() {
        // Write your code here
        return (Integer) list.get(i++);
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        return i < list.size();
    }

    @Override
    public void remove() {}


}

























