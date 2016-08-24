public class strStr{
    public static void main(String[] args){
        strStr obj = new strStr(); 
        String s1 = null;
        String s2 = "a";
        int output = obj.strStr(s1, s2);
        System.out.println(output); 
    }

    public int strStr(String haystack, String needle){
        if(haystack == null || needle == null){
            return -1;
        } 

        int hayLen = haystack.length();
        int needleLen = needle.length(); 


        if(needleLen == 0){
            return 0;
        }   

       for(int i = 0; i < hayLen; i++){
            if(needleLen + i > hayLen){
                return -1;
            }
            
            int temp = i;
            for(int j = 0; j < needleLen; j++){
                if(needle.charAt(j) == haystack.charAt(temp)){
                    if(j == needleLen -1){
                        return i;
                    }
                    ++temp;
                }
                else{
                    break;
                }
            }
        }

        return -1;
    }
}
