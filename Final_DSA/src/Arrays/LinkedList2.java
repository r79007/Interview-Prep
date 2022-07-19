package Arrays;

import java.util.*;


class LinkedList2{
    static class LinkedList {
        int val;
        LinkedList next;

        LinkedList(int val_) {
            this.val = val_;
        }

    }


        public static LinkedList merge(LinkedList head1, LinkedList head2) {

            if (head1 == null) {
                return head2;
            }

            if (head2 == null) {
                return head1;
            }

            if (head1.val < head2.val) {
                head1.next = merge(head1.next, head2);

                return head1;
            }
            if (head2.val < head1.val) {
                head2.next = merge(head1, head2.next);

                return head2;
            }
            if (head1.val == head2.val) {
                head1.next = merge(head1.next, head2);

                return head1;
            }

            return null;

        }


        public static void main(String args[]) {

            Scanner sc = new Scanner(System.in);

            int length1 = sc.nextInt();
            int length2 = sc.nextInt();

            int headData1 = sc.nextInt();
            LinkedList head1 = new LinkedList(headData1);

            LinkedList temp1 = head1;

            for (int i = 0; i < length1 - 1; i++) {
                int nodeValues1 = sc.nextInt();

                LinkedList temp = new LinkedList(nodeValues1);

                temp1.next = temp;

                temp1 = temp1.next;
            }

            int headData2 = sc.nextInt();
            LinkedList head2 = new LinkedList(headData2);

            LinkedList temp2 = head2;

            for (int i = 0; i < length2 - 1; i++) {
                int nodeValues2 = sc.nextInt();

                LinkedList t = new LinkedList(nodeValues2);

                temp2.next = t;

                temp2 = temp2.next;
            }

            LinkedList mergedList = merge(head1, head2);

            LinkedList temp3 = mergedList;

            for (int i = 0; i < length1 + length2; i++) {
                System.out.print(temp3.val + " ");
                temp3 = temp3.next;
            }


        }

    }

