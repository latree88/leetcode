import java.util.*;

public class RussianDollEnvelopes{


    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 || 
            envelopes[0] == null || envelopes[0].length != 2){
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                	// 特别注意一下这个排序的顺序！！！！！！！
                	// 这个与后面的二分法有关系，所以如果长度一样，宽度的排序是反过来的
                    return b[1] - a[1];
                }
                else{
                    return a[0] - b[0];
                }
            }
        });
        
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                if(index < 0)
                    index = -index - 1;
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }

}















