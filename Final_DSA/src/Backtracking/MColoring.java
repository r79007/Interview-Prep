package Backtracking;

public class MColoring {

    int[] clr;

    public boolean graphColoring(boolean graph[][], int m, int n) {

        int row=0;
        int col=0;

        clr=new int[n];

        return helper(graph, m, 0);

    }

    private boolean helper(boolean graph[][], int m, int start){

        if(start==graph.length){
            return true;
        }


        int prev_clr=clr[start];
        for(int color=1;color<=m;color++){
            if(is_valid(graph, m, start, color)){

                if(helper(graph, m, start+1)==true){
                    return true;
                }else{
                    remove_color(start, prev_clr);
                }

            }

        }



        return false;
    }

    private boolean is_valid(boolean graph[][], int m, int idx, int c){

        for(int i=0;i<graph.length;i++){
            if(graph[i][idx]){
                if(clr[i]==c){
                    return false;
                }
            }

            if(graph[idx][i]){
                if(clr[i]==c){
                    return false;
                }
            }

        }

        clr[idx]=c;

        return true;

    }

    private void remove_color(int idx, int color){
        clr[idx]=color;
    }

}
