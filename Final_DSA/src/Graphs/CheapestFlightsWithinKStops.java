package Graphs;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] graph, int src, int dst, int k) {

        int[][] dp=new int[k+2][n];

        for(int i=0;i<=k+1;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<=k+1;i++){
            dp[i][src]=0;

        }

        for(int i=1;i<=k+1;i++){
            for(int j=0;j<graph.length;j++){

                int s=graph[j][0];
                int d=graph[j][1];
                int w=graph[j][2];

                if(dp[i-1][s]!=Integer.MAX_VALUE){
                    dp[i][d]=Math.min(dp[i][d], dp[i-1][s]+w);
                }

            }
        }

        return (dp[k+1][dst] == Integer.MAX_VALUE)? -1: dp[k+1][dst];

    }

}
