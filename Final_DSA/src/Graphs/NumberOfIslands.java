package Graphs;

public class NumberOfIslands {
    class Solution {
        int[][] dir={{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int cnt=0;

        public boolean check(int i, int j, char[][] grid){
            int m=grid.length;
            int n=grid[0].length;

            if(i<m && j<n && i>=0 && j>=0){
                return true;
            }
            return false;
        }

        public void fill(int i, int j, char[][] grid){
            grid[i][j]='0';

            for(int k=0;k<dir.length;k++){
                int newi=i+dir[k][0];
                int newj=j+dir[k][1];

                if(check(newi, newj, grid)==true && grid[newi][newj]=='1'){

                    fill(newi, newj, grid);

                }

            }
        }

        public int numIslands(char[][] grid) {



            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        cnt++;
                        fill(i, j, grid);

                    }
                }
            }

            return cnt;

        }
    }
}
