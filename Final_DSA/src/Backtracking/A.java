package Backtracking;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();

            int avg=n/3;

            int first, second, third;
            first=avg;
            second=avg;
            third=avg;

            int rem=n-3*avg;

            first+=rem;

            while(first<=second || second<=third || first<=third || first<0 || second<0 || third<0){

                if(second>=first){
                    second--;
                    first++;
                }

                if(second<=third){
                    third--;
                    second++;
                }

            }

            System.out.print(second+" "+first+" "+third);
            System.out.println();

        }

    }


}
