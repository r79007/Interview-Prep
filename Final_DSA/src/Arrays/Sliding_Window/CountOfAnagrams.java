package Arrays.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class CountOfAnagrams {

    public static void main(String[] args) {

        String input = "eaylnlfdxf";

        String pattern = "irc";


        System.out.println(search(pattern, input));

    }


    static int search(String pat, String s) {
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0;i<pat.length();i++){
            map.putIfAbsent(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }



        int count=map.size();

        int j=0;
        int i=0;

        int num=0;

        while(j<s.length()){

            if(map.containsKey(s.charAt(j))){
                if(map.get(s.charAt(j))>0){
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0){
                        count--;
                    }

                    if(count==0){
                        num++;
                    }
                }

            }

            if(j-i+1==pat.length()){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }

            if(j-i+1<pat.length()){
                j++;
            }



        }

        return num;



    }


}
