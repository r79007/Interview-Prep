package BinaryTrees;

import java.util.*;

public class TopView {

    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q=new LinkedList<>();

        ArrayList<Integer> ans=new ArrayList<>();

        Map<Integer, Integer> map=new TreeMap<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){

            Pair curr=q.poll();

            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node.data);
            }

            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1, curr.node.left));
            }

            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }


        }

        for(Integer i:map.keySet()){
            ans.add(map.get(i));
        }

        return ans;
    }

    static class Pair{
        int hd;
        Node node;

        Pair(int hd_, Node node_){
            this.hd=hd_;
            this.node=node_;
        }
    }
}
