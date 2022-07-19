package Greedy;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

    public static long findMaxPoints(int N, int W, long[][] matrix){

        long[][] dp=new long[N+1][W+1];

        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(j==0){
                    dp[i][j]=0;
                    continue;
                }

                if(matrix[i-1][2]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][(int) (j-matrix[i-1][2])] + matrix[i-1][0]*matrix[i-1][1]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<N+1;i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[N][W];

    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int N = sc.nextInt();
        int W = sc.nextInt();
        while(t-->0) {
            long[][] matrix = new long[N][3];

            for (int i = 0; i < N; i++) {
                matrix[i][0] = sc.nextLong();
                matrix[i][1] = sc.nextLong();
                matrix[i][2] = sc.nextLong();
            }

            System.out.println(findMaxPoints(N, W, matrix));
        }
    }
}
