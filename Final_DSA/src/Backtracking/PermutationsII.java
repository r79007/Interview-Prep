package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsII {

    static List<List<Integer>> ans;


    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used=new boolean[nums.length];

        List<Integer> l=new ArrayList<>();

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }

        ans=new ArrayList<>();

        helper(nums, l, map);

        return ans;

    }

    public static void helper(int[] nums, List<Integer> l, HashMap<Integer, Integer> map){

        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));

            return;
        }

        for(Integer i:map.keySet()){

            if(map.get(i)>0){
                l.add(i);
                map.put(i, map.get(i)-1);
                helper(nums, l, map);


                map.put(i, map.get(i)+1);
                l.remove(l.size()-1);

            }

        }


    }

    public static void main(String[] args) {
        List<List<Integer>> res=permuteUnique(new int[] {1, 1, 2});

        for(List<Integer> l : res){
            System.out.println(l);
        }

    }

}
