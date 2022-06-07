package Backtracking;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0){

            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];

            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }

            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }

            int maxAWithZero=Integer.MIN_VALUE;
            int maxIndex=-1;

            int max_diff_idx_where_b_not_zero=-1;
            int max_diff=Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                if(maxAWithZero<a[i] && b[i]==0){
                    maxAWithZero=a[i];
                    maxIndex=i;
                }
                if(b[i]!=0 && max_diff<a[i]-b[i]){
                    max_diff=a[i]-b[i];
                }
            }

            if(maxAWithZero==Integer.MIN_VALUE){
                maxAWithZero=0;

            }

            if(max_diff<maxAWithZero){
                System.out.println("NO");

            }
            else {
                int diff = 0;
                int newDiff = 0;
                for (int i = 0; i < n; i++) {
                    a[i] -= maxAWithZero;

                    newDiff = a[i] - b[i];

                    if (newDiff < 0) {
                        System.out.println("NO");
                        break;
                    } else if (i != 0) {
                        if (newDiff != diff && b[i] != 0) {
                            System.out.println("NO");
                            break;
                        }
                    }
                    if (b[i] != 0) {
                        diff = a[i] - b[i];
                    }
                    if (i == n - 1) {
                        System.out.println("YES");
                        break;
                    }
                }
            }



        }


    }

}
