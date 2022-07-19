package StacksQueues;

import java.util.Stack;

public class removeDuplicates {

    public static String removeDuplicateLetters(String s) {

        Stack<Character> st = new Stack<>();

        int[] arr = new int[26];
        boolean[] arr2 = new boolean[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                char ch = (char)(i+'a');
                st.push(ch);
                arr[ch-'a']--;
                arr2[ch-'a']=true;
            }

            if(st.size()>0 && st.peek()>s.charAt(i) && arr2[s.charAt(i)-'a']==false){
                while(st.size()>0 && st.peek()>s.charAt(i) && arr[st.peek()-'a']>1){
                    arr[st.peek()-'a']--;
                    arr2[st.peek()-'a']=false;
                    st.pop();
                }
                if(arr2[s.charAt(i)-'a']==false)
                    st.push(s.charAt(i));
                arr2[s.charAt(i)-'a']=true;
            }
        }

        String ans = "";

        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }

        return ans;

    }

    public static void main(String[] args) {
        String str = "bcabc";

        System.out.println(removeDuplicateLetters(str));
    }

}
