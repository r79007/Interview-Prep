package Arrays.Two_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {

    public static int threeSumClosest(ArrayList<Integer> A, int B) {

        Collections.sort(A);


        int closestSum=A.get(0)+A.get(1)+A.get(A.size()-1);

        for(int i=0;i<A.size();i++){



            int a=A.get(i);

            int l=i+1;
            int r=A.size()-1;

            while(l<r){

                long sum=a+A.get(l)+A.get(r);

                if(sum<=B){
                    l++;
                }
                else if(sum>B){
                    r--;
                }

                if(Math.abs(closestSum-B)>Math.abs(sum-B)){
                    closestSum=(int)sum;
                }


                // while(l>0 && A.get(l-1)==A.get(l) && l<r){
                //     l++;
                // }


            }


        }
        return closestSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(2147483647, -2147483648, -2147483648, 0, 1));

        int B=0;

        System.out.println(threeSumClosest(arr, 0));

    }

}
