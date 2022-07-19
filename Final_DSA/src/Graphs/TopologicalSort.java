package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    class Solution
    {
        static int[] vis;
        static Stack<Integer> st;
        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            st=new Stack<>();
            vis=new int[V];

            for(int i=0;i<V;i++){
                if(vis[i]==0){
                    dfs(i, adj, st);
                }
            }

            int[] ans=new int[st.size()];

            int i=0;
            while(!st.isEmpty()){
                ans[i++]=st.pop();
            }

            return ans;

        }

        static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){

            vis[node]=1;

            for(Integer i:adj.get(node)){
                if(vis[i]==0){
                    dfs(i, adj, st);
                }
            }

            st.push(node);

        }
    }

}
