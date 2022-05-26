package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByNight {

    static int[][] dir={{2,1}, {-1, -2}, {1, 2}, {-1, 2}, {-2, -1}, {1, -2}, {2, -1}, {-2, 1}};
    static int[][] vis;
    //Function to find out minimum steps Knight needs to reach target position.

    public static boolean check(int i ,int j, int N){
        if(i>=0 && j>=0 && i<N && j<N){
            return true;
        }

        return false;
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<int[]> q=new LinkedList<>();
        vis=new int[N][N];

        int steps=0;
        int si=KnightPos[0]-1;
        int sj=KnightPos[1]-1;


        int dx=TargetPos[0]-1;
        int dy=TargetPos[1]-1;

        if(si==dx && sj==dy){
            return 0;
        }

        q.add(new int[] {si, sj, 0});
        vis[si][sj]=1;

//        for (int[] ints : dir) {
//            int newi = si + ints[0];
//            int newj = sj + ints[1];
//            if (check(newi, newj, N) == true && (vis[newi][newj] == 0)) {
//                q.add(new int[]{newi, newj, 1});
//                vis[newi][newj] = 1;
//            }
//        }


        while(!q.isEmpty()){

            int[] pos=q.poll();

            int x=pos[0];
            int y=pos[1];
            int level=pos[2];

            for (int[] ints : dir) {
                int newx = x + ints[0];
                int newy = y + ints[1];

                if (check(newx, newy, N) == true && (vis[newx][newy] == 0)) {
                    if (newx == dx && newy == dy) {
                        return level + 1;
                    }
                    q.add(new int[]{newx, newy, level + 1});
                    vis[newx][newy] = 1;
                }
            }



        }




        return -1;

    }

    public static void main(String[] args) {
        int N=3;
        int[] arr1={3, 3};
        int[] arr2={2, 1};

        System.out.println(minStepToReachTarget(arr1 ,arr2, N));
    }

}
