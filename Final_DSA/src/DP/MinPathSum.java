package DP;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int[] curr=new int[grid[0].length];

        curr[0]=grid[0][0];

        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]=grid[i][j];
                    continue;
                }

                int right = Integer.MAX_VALUE;
                if(j>0) right=curr[j-1] + grid[i][j];
                int left = Integer.MAX_VALUE;
                if(i>0) left = prev[j] + grid[i][j];

                curr[j] = Math.min(right, left);

            }
            prev=curr;
        }

        return prev[m-1];



    }

}
