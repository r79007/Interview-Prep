package Graphs;
import java.util.*;
import java.io.*;
import java.lang.*;

public class DetectCycleDirected {

    /*Complete the function below*/

    class Solution {
        int[] vis;
        int[] recS;
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            vis=new int[V];
            recS=new int[V];

            for(int i=0;i<V;i++){
                if(vis[i]==0){
                    if(dfs(i,V, adj)) return true;
                }
            }

            return false;
        }

        public boolean dfs(int node, int V,  ArrayList<ArrayList<Integer>> adj){
            vis[node]=1;
            recS[node]=1;

            for(Integer it:adj.get(node)){
                if(vis[it]!=1){
                    if(dfs(it, V, adj)) return true;
                }else if(recS[it]!=0){           //we are not checking if it is the parent or not because it is a directed graph
                    return true;
                }
            }
            recS[node]=0;

            return false;
        }
    }
}
