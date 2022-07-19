package LinkedList;




public class ReverseK {

    public static Node reverseMO(Node node){

        if(node==null){
            return null;
        }

        if(node.next==null){
            return node;
        }

        Node smallTail=node.next;
        Node smallHead=reverseMO(node.next);
        smallTail.next=node;
        node.next=null;

        return smallHead;


    }

    public static Node reverse(Node node, int k)
    {

        if(node==null){
            return null;
        }

        if(node.next==null){
            return node;
        }

        Node head=node;
        Node tail=node;
        Node tempHead=node;

        for(int i=0;i<k-1;i++) {
            if(tail.next!=null) {
                tail=tail.next;
            }
        }
        //pos+=i;
        Node Next=tail;
        Node tail2=tail;

        Next=tail.next;
        tail2.next=null;

        Node newHead=reverseMO(node);

        head.next=reverse(Next, k);

        return newHead;
    }

}
