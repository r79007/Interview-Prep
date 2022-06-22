package BinaryTrees.BST;

import org.w3c.dom.Node;

public class FindSumOfAllGreater {

    class Node
 {
     int data;
     Node left, right;

         public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }
    int sum=0;
    // modify the BST and return its root
    public Node modify(Node root)
    {

        helper(root);

        return root;



    }

    public void helper(Node root){

        if(root==null){
            return ;
        }

        helper(root.right);

        sum+=root.data;
        root.data=sum;

        helper(root.left);



    }

}
