package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

    public ArrayList<Integer> reverseLevelOrder(Node root)
    {
        Stack<ArrayList<Integer>> st=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        //st.push(root);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node frontNode = q.poll();
                //st.push(frontNode);
                temp.add(frontNode.data);
                if(frontNode.left!=null){
                    q.add(frontNode.left);
                }
                if(frontNode.right!=null){
                    q.add(frontNode.right);
                }
            }
            st.push(temp);
            //System.out.println(temp.size());
        }
        while(!st.isEmpty()){
            ans.addAll(st.pop());
            // ArrayList<Integer> ans2=st.pop();
            // ans.addAll(ans2);

        }
        return ans;
    }

}
