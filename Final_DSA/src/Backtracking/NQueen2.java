package Backtracking;

import java.util.ArrayList;

public class NQueen2 {

    static boolean[][] possible;
    static ArrayList<ArrayList<String>> ans;
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {

        ArrayList<String> ad=new ArrayList<>();
        ans=new ArrayList<>();
        possible=new boolean[a][a];
//            for(int i=0;i<a;i++){
//                for(int j=0;j<a;j++){
//                    possible[i][j]=false;
//                }
//            }

        function(0,a,ad);
        return ans;

    }
    public static ArrayList<String> function(int row,int a,ArrayList<String> ad){



        boolean any_poss=false;
        for(int i=0;i<a;i++){
            if(is_not_under_attack(a, row, i)){
                possible[row][i]=true;
                any_poss=true;
                String s="";
                for(int f=0;f<i;f++) s+=".";
                s+="Q";
                for(int f=0;f<a-i-1;f++) s+=".";
                ad.add(s);

                if(row+1==a){
                    if(ad.size()!=0)
                        ans.add(ad);
                    return ad;
                }

                function(row+1,a, ad);

                ad.remove(ad.size()-1);
                possible[row][i]=false;

            }
        }
//            if(!any_poss){
//                ad=new ArrayList<>();
//                return;
//            }
        return ad;
    }

    private static boolean is_not_under_attack(int n, int row, int col){



        for(int i=0;i<=row;i++){

            if(possible[i][col]==true){
                return false;
            }

            if(row - i >= 0 && col - i >= 0 && possible[row - i][col - i]==true) return false;
            if(row - i >= 0 && col + i <  n && possible[row - i][col + i]==true) return false;

        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}

