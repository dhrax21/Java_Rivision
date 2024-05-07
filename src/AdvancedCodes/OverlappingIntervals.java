package AdvancedCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
/* { Intervals = {{1,3},{2,4},{6,8},{9,10}}
        Output: {{1, 4}, {6, 8}, {9, 10}}
        Explanation: Given intervals: [1,3],[2,4]
        [6,8],[9,10], we have only two overlapping
        intervals here,[1,3] and [2,4]. Therefore
        we will merge these two and return [1,4],
        [6,8], [9,10] }

 */
public class OverlappingIntervals {
    class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int s,int e){
            this.start=s;
            this.end=e;
        }

        public int compareTo(Pair obj){
            return this.start-obj.start;
        }
    }
    public int[][] overlappedInterval(int[][] Intervals)
    {
        List<Pair> list=new ArrayList<>();
        for(int[] x : Intervals){
            list.add(new Pair(x[0],x[1]));
        }

        Collections.sort(list);

        List<Pair> merged=new ArrayList<>();
        Pair temp=list.get(0);
        for(int i=1; i<list.size(); i++){
            Pair curr=list.get(i);

            int s1=temp.start;
            int e1=temp.end;
            int s2=curr.start;
            int e2=curr.end;

            if(s2 <= e1){
                temp.end=Math.max(e1,e2);
            }else{
                merged.add(temp);
                temp=curr;
            }
        }
        merged.add(temp);
        int[][] ans=new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++){
            ans[i][0]=merged.get(i).start;
            ans[i][1]=merged.get(i).end;
        }
        return ans;

    }
}
