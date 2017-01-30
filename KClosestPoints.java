import java.util.*;

public class KClosetPoints{


	class Point {
	    int x;
	    int y;
	    Point() { x = 0; y = 0; }
	    Point(int a, int b) { x = a; y = b; }
	}




    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here   
        
        final Point temp = new Point(origin.x, origin.y);
        PriorityQueue<Point> heap = new PriorityQueue<Point>(points.length, new Comparator<Point>(){
            public int compare(Point a, Point b){
                int aDistance = (a.x - temp.x) * (a.x - temp.x) + (a.y - temp.y) * (a.y - temp.y);
                int bDistance = (b.x - temp.x) * (b.x - temp.x) + (b.y - temp.y) * (b.y - temp.y);
                
                if(aDistance == bDistance){
                    if(a.x == b.x){
                        return b.y - a.y;
                    }
                    return b.x - a.x;
                }
                return aDistance - bDistance;
            }
        });
        
        for(Point onePoint : points){
            heap.add(new Point(onePoint.x, onePoint.y));
        }
        
        // System.out.println("&&&&&&&&&&");
        int size = 0;
        if(k > points.length){
            size = points.length;
        }
        else{
            size = k;
        }
        
        Point[] res = new Point[size];
        
        for(int i = 0; i < size; i++){
            res[i] = heap.poll();
        }
        
        return res;
    }	
}
















