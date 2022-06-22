package Arrays.Two_Pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSumZero {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }

            int a=nums[i];

            int l=i+1;
            int r=nums.length-1;

            while(l<r){

                int sum=a+nums[l]+nums[r];

                if(sum<0){
                    l++;
                }
                else if(sum>0){
                    r--;
                }
                else{
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(a);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    while(l>0 && nums[l-1]==nums[l] && l<r){
                        l++;
                    }
                }

            }



        }
        return res;
    }

}
