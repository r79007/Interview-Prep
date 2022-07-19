package LinkedList;

public class BubbleSort {

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static int length(LinkedListNode<Integer> head){
        int l=0;
        LinkedListNode<Integer> temp=head;
        while(temp!=null) {
            l++;
            temp=temp.next;
        }
        return l;
    }

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {

        if(head==null || head.next==null) {
            return head;
        }
        LinkedListNode<Integer> pre=null;
        LinkedListNode<Integer> current=head;
        int l=length(head);
        for(int i=0;i<=l-1;i++) {

            pre=null;
            current=head;
            while(current.next!=null)
            {
                if(current.data<=current.next.data)
                {
                    pre=current;
                    current=current.next;
                }
                else if(current.data>current.next.data)
                {
                    LinkedListNode Next=current.next;
                    if(pre!=null)
                    {
                        pre.next=Next;
                        current.next=Next.next;
                        Next.next=current;
                        pre=Next;
                    }
                    else
                    {

                        current.next=Next.next;
                        Next.next=current;
                        head=Next;
                        pre=head;
                    }

                }
            }
        }

        return head;
    }

}
