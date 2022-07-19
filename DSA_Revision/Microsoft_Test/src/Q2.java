import java.util.HashMap;

public class Q2 {

    public static int solution(int[] A, int S) {
        int[] commonArr=new int[2];
        commonArr[0]=0;
        commonArr[1]=1;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long curr=commonArr[0];
        int ans =commonArr[0];

        for(int i=0;i<A.length;i++){
            curr=curr+A[i];
            long idx=curr-(S*(i+commonArr[1]));

            if(map.containsKey(idx)){
                ans = ans + map.get(idx);
                map.put(idx, map.get(idx)+commonArr[1]);
            }
            else{
                map.put(idx, commonArr[0]);
                map.put(idx, 1);
            }

            //map.put(idx, map.get(idx)+commonArr[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr=new int[(int)1e6];
        int k=(int)1e9;
        System.out.println(solution(new int[] {0, 4, 3, -1}, 2));
    }

}
