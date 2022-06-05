package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static List<List<Integer>> ans;

    public static List<List<Integer>> permute(int[] nums) {

        ans=new ArrayList<>();

        List<Integer> l=new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        helper(used, l, nums);

        return ans;

    }

    public static void helper(boolean[] used, List<Integer> l, int[] nums){

        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                l.add(nums[i]);
                used[i]=true;

                helper(used, l, nums);

                used[i]=false;

                l.remove(l.size()-1);

            }

        }

    }

    public static void main(String[] args) {
        List<List<Integer>> res=permute(new int[] {1, 2, 3});

        for(List<Integer> l : res){
            System.out.println(l);
        }

    }

}
