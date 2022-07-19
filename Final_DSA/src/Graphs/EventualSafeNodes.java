package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  EventualSafeNodes {

    HashMap<Integer, Boolean> map=new HashMap<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {


        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            if(dfs(i, graph)){
                ans.add(i);
            }
        }

        return ans;

    }

    private boolean dfs(int i, int[][] graph) {

        if(map.containsKey(i)){
            return map.get(i);
        }

        map.put(i, false);

        for(Integer x : graph[i]){
            if(!dfs(x, graph)){
                return false;
            }
        }

        map.put(i, true);

        return true;



    }

}
