package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis=new int[V+1];
        Arrays.fill(vis,0);

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(check(i,vis,adj,-1)==true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, int par){
        vis[node]=1;

        for(Integer i:adj.get(node)){
            if(vis[i]==0){
                if(check(i,vis,adj,node)){
                    return true;
                }
            }else if(i!=par){   //checking for a back edge
                return true;
            }
        }
        return false;
    }
}
