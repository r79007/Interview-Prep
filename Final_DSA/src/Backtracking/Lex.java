package Backtracking;

import java.util.Stack;

public class Lex {

    public static String mostCompetitive(String nums, int k) {
        Stack<Character> stack = new Stack<>();
        char[] ans = new char[k];
        for(int i = 0; i < nums.length(); i++) {
            while(!stack.isEmpty() && nums.charAt(i) < stack.peek() && (nums.length() - i + stack.size()) > k) stack.pop();
            if (stack.size() < k) ans[stack.size()] = nums.charAt(i);
            stack.push(nums.charAt(i));
        }

        String str=new String(ans);

        return str;
    }

    public static void main(String[] args) {
        String s="dad";
        System.out.println(mostCompetitive(s, 3));
    }
}
