package BinaryTrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int sz=q.size();
            for(int i=0;i<sz;i++){

                TreeNode node=q.poll();

                if(node!=null){
                    if(i==sz-1){

                        ans.add(node.val);
                    }

                    if(node.left!=null){
                        q.add(node.left);
                    }

                    if(node.right!=null){
                        q.add(node.right);
                    }
                }


            }


        }

        return ans;

    }
}
