package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {

        ans=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        int start = 1;

        helper(n, k, l, start);

        return ans;

    }

    private void helper(int n, int k, List<Integer> l, int start){

        if(l.size()==k){
            ans.add(new ArrayList(l));
            return;
        }

        for(int i=start;i<=n;i++){

            l.add(i);

            helper(n, k, l, i+1);

            l.remove(l.size()-1);

        }

    }

}
