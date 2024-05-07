package GfgPracticeProblem;

import java.util.ArrayList;
import java.util.Collections;

public class NMeetingOneRoom {
    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }

        public int compareTo(Pair p){
            return this.second-p.second;
        }

    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            Pair p=new Pair(start[i],end[i]);
            list.add(p);
        }
        Collections.sort(list);

        int ans=1;
        Pair curr=list.get(0);

        for(int i=1; i<n; i++){
            if(curr.second<list.get(i).first){
                ans++;
                curr=list.get(i);
            }
        }

        return ans;
    }
}

//        6                         {Inputs N=sizeofarray}
//        1 3 0 5 8 5               {Start time for meeting}
//        2 4 6 7 9 9               {end time for meeting}
