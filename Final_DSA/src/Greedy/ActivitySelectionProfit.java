package Greedy;

import java.util.Arrays;

class period implements Comparable<period>{
    int s;
    int e;
    int p;
    period(int s, int e, int p){
        this.s = s;
        this.e = e;
        this.p = p;
    }

    @Override
    public int compareTo(period o){
        return this.e - o.e;
    }

    @Override
    public String toString(){
        return this.s+" "+this.e+" "+this.p;
    }

}

public class ActivitySelectionProfit {

    public static int getRec(period arr[], int end, int profit, int i){
        if(i>=arr.length){
            return profit;
        }

        int include = 0;
        int notInclude = 0;
        if(arr[i].s>=end){
            include = getRec(arr, arr[i].e, profit+arr[i].p, i+1);
        }
        notInclude = getRec(arr, end, profit, i+1);
        int ans = Math.max(notInclude, include);
        return ans;
    }


    public static int get(int start[], int end [], int profit[]){
        period arr[] = new period[start.length];
        for(int i =0; i<start.length; i++){
            arr[i] = new period(start[i], end[i], profit[i]);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int ans = getRec(arr, 0, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        int start[] = {1 , 3, 6, 2};
        int end [] = {2, 5, 9, 100};
        int profit[] = {50, 20, 100, 200};
        System.out.println(get(start, end, profit));
    }
}