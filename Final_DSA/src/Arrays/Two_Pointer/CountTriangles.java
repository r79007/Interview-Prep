package Arrays.Two_Pointer;

import java.util.ArrayList;
import java.util.Collections;

public class CountTriangles {

    public int nTriang(ArrayList<Integer> A) {

        Collections.sort(A);
        double count=0;
        for(int i=A.size()-1;i>0;i--){

            int c=A.get(i);

            int l=0;
            int r=i-1;


            while(l<r){

                int a=A.get(l);
                int b=A.get(r);

                if(a+b<=c){
                    l++;
                }
                else{
                    count+=(r-l)%(1e9+7);

                    r--;
                }

            }


        }

        count=count%(1e9+7);

        int ans=(int)count;

        return ans;

    }

}
