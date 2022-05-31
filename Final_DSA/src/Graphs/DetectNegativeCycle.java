package Graphs;

public class DetectNegativeCycle {

    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist=new int[n];

        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        dist[0]=0;
        for(int k=1;k<=n-1;k++){
            for(int i=0;i<edges.length;i++){

                int u=edges[i][0];
                int v=edges[i][1];
                int w=edges[i][2];

                if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for(int i=0;i<edges.length;i++){

            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];

            if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
                return 1;
            }
        }


        return 0;
    }

}
