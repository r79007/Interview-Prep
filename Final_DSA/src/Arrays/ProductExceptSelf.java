package Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] res=new int[nums.length];
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i]*res[i-1];
        }


        res[res.length-1]=res[res.length-2];
        int rightProd=nums[nums.length-1];

        for(int i=res.length-2;i>=1;i--){
            res[i]=res[i-1]*rightProd;
            rightProd*=nums[i];
        }

        res[0]=rightProd;
        return res;

    }


}
