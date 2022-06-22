package BinaryTrees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatinNextRightPtrs {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int sz=q.size();


            for(int i=0;i<sz;i++){
                if(i==sz-1){
                    Node node=q.poll();

                    addNodes(q, node);
                    if(node!=null)
                        node.next=null;
                }else{

                    Node node1 = q.poll();
                    Node node2 = q.peek();

                    addNodes(q, node1);
                    if(node1!=null)
                        node1.next=node2;

                }
            }
        }

        return root;

    }

    private void addNodes(Queue<Node> q, Node node){

        if(node==null){
            return;
        }

        if(node.left!=null){
            q.add(node.left);
        }

        if(node.right!=null){
            q.add(node.right);
        }


    }

}
