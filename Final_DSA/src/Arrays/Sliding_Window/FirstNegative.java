package Arrays.Sliding_Window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegative {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> st=new LinkedList<>();
        ArrayList<Long> arrl=new ArrayList<>();

        int i=0;
        int j=0;

        while(j<N){

            if(A[j]<0){
                st.add(A[j]);
            }

            if(j-i+1<K){
                j++;
                continue;
            }
            else if(j-i+1==K){

                if(st.size()!=0){
                    arrl.add(st.peek());
                    if(st.peek()==A[i]){
                        st.poll();
                    }

                }else{
                    arrl.add(0L);
                }

                i++;
                j++;

            }





        }

        long[] ans=new long[arrl.size()];

        for(int p=0;p<arrl.size();p++){
            ans[p]=arrl.get(p);
        }

        return ans;

    }

}
