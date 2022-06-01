package Backtracking;

public class NQueens {

    int[][] matrix;

    public int totalNQueens(int n) {

        int count = 0;

        matrix = new int[n][n];

        return helper(n, 0, count);


    }

    private int helper(int n, int row, int count){

        for(int col=0;col<n;col++){

            if(is_not_under_attack(n, row, col)){

                place_queen(n, row, col);

                if(row + 1 == n){
                    count++;
                }else{
                    count = helper(n, row + 1, count);
                }

                remove_queen(n, row, col);

            }

        }

        return count;

    }

    private void place_queen(int n, int row, int col){

        matrix[row][col]=1;

    }

    private void remove_queen(int n, int row, int col){

        matrix[row][col]=0;

    }

    private boolean is_not_under_attack(int n, int row, int col){



        for(int i=0;i<=row;i++){

            if(matrix[i][col]==1){
                return false;
            }

            if(row - i >= 0 && col - i >= 0 && matrix[row - i][col - i]==1) return false;
            if(row - i >= 0 && col + i <  n && matrix[row - i][col + i]==1) return false;

        }

        return true;

    }

}
