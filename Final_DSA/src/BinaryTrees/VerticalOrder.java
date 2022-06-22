package BinaryTrees;

import java.util.*;

public class VerticalOrder {

    static ArrayList<Integer> verticalOrder(Node root)
    {
        return helper(root);
    }

    public static ArrayList<Integer> helper(Node root)
    {
        Queue<Pair> q=new LinkedList<>();

        ArrayList<Integer> ans=new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map=new TreeMap<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){

            Pair curr=q.poll();

            if(!map.containsKey(curr.hd)){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd, temp);
            }else{
                map.get(curr.hd).add(curr.node.data);
            }

            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1, curr.node.left));
            }

            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }


        }

        for(Integer i:map.keySet()){
            ans.addAll(map.get(i));
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
