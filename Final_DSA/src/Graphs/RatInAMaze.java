package Graphs;
//Does not work
import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {

    static ArrayList<String> ans=new ArrayList<>();

    static int[][] dir={{1,0}, {-1, 0}, {0,1}, {0,-1}};

    public static boolean check(int i, int j, int[][] arr){
        int m=arr.length;
        int n=arr.length;

        if(i<m && j<n && i>=0 && j>=0){
            return true;
        }

        return false;

    }

    public static void fill(int i, int j, int[][] m, String s){

        if(i==m.length-1 && j==m[0].length-1){
            ans.add(s);
            return;
        }





        for(int k=0;k<dir.length;k++){
            int newi=i+dir[k][0];
            int newj=j+dir[k][1];

//            if(newi==m.length-1 && newj==m[0].length-1){
//                ans.add(s);
//                return;
//            }

            if(check(newi, newj, m)==true && m[newi][newj]==1){



                if(dir[k][0]==1){
                    s+="D";
                }else if(dir[k][0]==-1){
                    s+="U";
                }else if(dir[k][1]==1){
                    s+="R";
                }else{
                    s+="L";
                }


                m[i][j]=2;
                fill(newi, newj, m,s);
                m[i][j]=1;



            }

        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {

        if(m[0][0]==1){
            m[0][0]=2;
            fill(0,0,m, "");

        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int N=4;
        int[][] m={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        ArrayList<String> op=findPath(m , N);

        for(String s:op){
            System.out.print(s+" ");
        }
    }
}
