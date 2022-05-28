package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TimeNeededToInformAllEmployees {




        class Pair implements Comparable<Pair>{
            int x;
            int y;
            int time;

            Pair(int x_, int y_, int time_){
                this.x=x_;
                this.y=y_;
                this.time=time_;
            }

            public int compareTo(Pair b) {

                return (this.time - b.time);

            }

        }

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            ArrayList<ArrayList<int[]>> adj=new ArrayList<ArrayList<int[]>>();



            for(int i=0;i<=manager.length;i++){
                adj.add(new ArrayList<>());
            }
            boolean isMan=false;
            for(int i=0;i<manager.length;i++){
                // if(manager[i]==-1){
                //     adj.get(headID).add(new int[] {i, informTime[manager[i]]});
                // }
                if(manager[i]!=-1)
                    adj.get(manager[i]).add(new int[] {i, informTime[manager[i]]});
                isMan=true;

            }

            PriorityQueue<Pair> pq=new PriorityQueue<>();

            for(int i=0;i<adj.get(headID).size();i++){
                int[] emp=adj.get(headID).get(i);

                pq.add(new Pair(emp[0], informTime[emp[0]], informTime[headID]));
            }

            int res=-1;

            while(!pq.isEmpty()){
                Pair p=pq.poll();

                res=p.time;

                for(int i=0;i<adj.get(p.x).size();i++){
                    int[] emp=adj.get(p.x).get(i);

                    pq.add(new Pair(emp[0], informTime[emp[0]], p.time+informTime[manager[emp[0]]]));
                }

            }


            if(res==-1 && isMan==true){
                return 0;
            }

            return res;

        }




}
