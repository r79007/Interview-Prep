package StacksQueues;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        String ans = "";

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                int ascii = i;
                ascii+=(int)'a'-1;
                String ch = Character.toString((char)ascii);
                ans+=ch;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "bcabc";

        System.out.println(removeDuplicateLetters(str));

    }

}
