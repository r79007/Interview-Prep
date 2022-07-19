package Arrays;

public class NumSubarraysWithBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int res=0;
        int windowCount=0;
        int start=0;
        int end=0;

        while(end<nums.length){
            if(nums[end]>=left && nums[end]<=right){
                windowCount=end-start+1;
            }
            else if(nums[end]>right){
                windowCount=0;
                start=end+1;

            }


            res+=windowCount;
            end++;
        }
        return res;
    }

}
