package Arrays.Sliding_Window;

import java.util.HashMap;

public class LongestKUniqueCharacterSubstring {

    public static int longestkSubstr(String s, int k) {

        int i=0;
        int j=0;

        int maxLen=-1;
        HashMap<Character, Integer> map=new HashMap<>();

        while(j<s.length()){

            map.putIfAbsent(s.charAt(j), 0);
            map.put(s.charAt(j), map.get(s.charAt(j))+1);

            if(map.size()==k){
                maxLen=Math.max(maxLen, j-i+1);

            }



            else if(map.size()>k){
                while(map.size()>k){
                    if(map.get(s.charAt(i))==1){
                        map.remove(s.charAt(i));
                    }else{
                        map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    }
                    i++;
                }

            }

            j++;


        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="meayl";
        System.out.println(longestkSubstr(s, 2));
    }

}
