package BinaryTrees;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {

        if(root==null){
            return new ArrayList<>();
        }

        Queue<Node> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        q.add(root);

        List<Integer> first=new ArrayList<>();

        first.add(root.val);

        ans.add(first);

        while(!q.isEmpty()){



            List<Integer> currLevel=new ArrayList<>();

            int sz=q.size();

            for(int j=0;j<sz;j++){
                Node node=q.poll();
                for(int i=0;i<node.children.size();i++){
                    Node child=node.children.get(i);

                    q.add(child);
                    currLevel.add(child.val);

                }

            }


            if(currLevel.size()!=0)
                ans.add(currLevel);

        }

        return ans;

    }

}
