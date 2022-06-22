package Arrays.Two_Pointer;

import java.util.ArrayList;

public class Diffk {

    public int diffPossible(ArrayList<Integer> A, int B) {

        int i=0;

        int j=1;

        while(j<A.size()){

            int diff=A.get(j)-A.get(i);

            if(diff==B && i!=j){
                return 1;
            }
            else if(diff>B){
                i++;
            }
            else{
                j++;
            }

        }
        return 0;
    }

}
