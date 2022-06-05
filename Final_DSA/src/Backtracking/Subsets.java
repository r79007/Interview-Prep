package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {

        ans=new ArrayList<>();

        List<Integer> l=new ArrayList<>();

        helper(l, nums, 0);

        return ans;

    }

    public void helper(List<Integer> l, int[] nums, int i){

        if(i==nums.length){   //we are at leaf nodes
            ans.add(new ArrayList<>(l));
            return;
        }

        l.add(nums[i]);   //taking nums[i]

        helper(l, nums, i+1);

        l.remove(l.size()-1);   //not taking nums[i]

        helper(l, nums, i+1);



    }

}
