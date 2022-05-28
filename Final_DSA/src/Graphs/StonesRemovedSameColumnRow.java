package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class StonesRemovedSameColumnRow {


    static class UnionFind{
        HashMap<Integer, Integer> parent;
        HashMap<Integer, Integer> rank;
        int count;

        UnionFind(int[][] stones){
            parent = new HashMap<>();
            rank=new HashMap<>();


            for(int[] stone: stones){

                // Using negative sign for row and positive for col
                // 1 added so that we dont get 0

                int row=-(stone[0]+1);
                int col=(stone[1]+1);

                parent.put(row, row);
                parent.put(col, col);

            }

            count = parent.size();

        }

        public int findSet(int x){
            if(parent.get(x)!=x){

                parent.put(x, findSet(x));

            }

            return parent.get(x);
        }

        public void union_(int x, int y){
            int xset=findSet(x);
            int yset=findSet(y);

            if(xset==yset){
                return;
            }

            count--;

            if(rank.get(xset)<rank.get(yset)){
                parent.put(xset, yset);
            }else if(rank.get(xset)>rank.get(yset)){
                parent.put(yset, xset);
            }else{
                parent.put(yset, xset);
                rank.put(xset, yset + 1);
            }
        }



    }


    public static int removeStones(int[][] stones) {

        UnionFind uf = new UnionFind(stones);
        for(int[] stone: stones){
            int row=-(stone[0]+1);
            int col=(stone[1]+1);

            uf.union_(row, col);

        }

        return stones.length - uf.count;

    }

    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        System.out.println(removeStones(stones));
    }


}
