package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        List<String> l=new ArrayList<>();

        helper(s, l, 0);

        return ans;

    }

    public void helper(String s, List<String> l, int idx){

        if(idx>=s.length()){
            ans.add(new ArrayList<>(l));
            return;
        }

        for(int k=idx;k<s.length();k++){
            if(isPalindrome(s, idx, k)){
                l.add(s.substring(idx, k+1));
                helper(s, l, k+1);
                l.remove(l.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s, int i, int j){

        int r=j;
        int l=i;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
