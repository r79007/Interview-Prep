package Arrays.Sliding_Window;

import java.util.HashMap;

public class LongestSubsequenceWithNoRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        int i=0;
        int j=0;

        int maxLen=0;

        HashMap<Character, Integer> map=new HashMap<>();

        while(j<s.length()){

            map.putIfAbsent(s.charAt(j), 0);
            map.put(s.charAt(j), map.get(s.charAt(j))+1);

            if(map.size()==j-i+1){
                maxLen=Math.max(maxLen, j-i+1);

            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }

                if(map.size()==j-i+1){
                    maxLen=Math.max(maxLen, j-i+1);

                }
            }

            j++;

        }

        return maxLen;

    }

    public static void main(String[] args) {
        String s="abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

}
