package AdvancedCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Given a collection of Intervals, the task is to merge all the overlapping Intervals.
/* { Intervals = {{1,3},{2,4},{6,8},{9,10}}
        Output: {{1, 4}, {6, 8}, {9, 10}}
        Explanation: Given intervals: [1,3],[2,4]
        [6,8],[9,10], we have only two overlapping
        intervals here,[1,3] and [2,4]. Therefore,
        we will merge these two and return [1,4],
        [6,8], [9,10] }

 */
public class OverlappingIntervals {
    static class Pair implements Comparable<Pair>{
        int start;
        int end;

        public Pair(int s,int e){
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
            list.add(new Pair(x[0], x[1]));
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

//class GFG {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine().trim());
//        while (T-- > 0) {
//            int n = Integer.parseInt(br.readLine().trim());
//            int[][] arr = new int[n][2];
//            for (int i = 0; i < n; i++) {
//                String temp[] = br.readLine().trim().split(" ");
//                arr[i][0] = Integer.parseInt(temp[0]);
//                String x = temp[1];
//                arr[i][1] = Integer.parseInt(x);
//            }
//            Solution obj = new Solution();
//            // The mergeOverlap function now returns a List<int[]>
//            List<int[]> ans = obj.mergeOverlap(arr);
//
//            // Printing the merged arr
//            for (int[] interval : ans) {
//                System.out.print(interval[0] + " " + interval[1] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
//
//// } Driver Code Ends
//class Solution {
//    class Pair implements Comparable<Pair>{
//        int start;
//        int end;
//
//        public Pair(int s,int e){
//            this.start=s;
//            this.end=e;
//        }
//
//
//        @Override
//        public int compareTo(Pair obj){
//            return this.start-obj.start;
//        }
//    }

    // updated gfg problemsolution
//    public List<int[]> mergeOverlap(int[][] arr) {
//
//        List<Pair> list=new ArrayList<>();
//
//        for(int[] x : arr){
//            list.add(new Pair(x[0],x[1]));
//        }
//
//        Collections.sort(list);
//
//        List<Pair> merged=new ArrayList<>();
//
//        Pair temp=list.get(0);
//
//        for(int i=1; i<list.size(); i++){
//            Pair curr=list.get(i);
//
//            int s1=temp.start;
//            int e1=temp.end;
//            int s2=curr.start;
//            int e2=curr.end;
//
//            if(s2<=e1){
//                temp.end=Math.max(e1,e2);
//            }else{
//                merged.add(temp);
//                temp=curr;
//            }
//        }
//        merged.add(temp);
//        List<int[]> ans = new ArrayList<>();
//
//        for(Pair p : merged){
//            ans.add(new int[]{p.start,p.end});
//        }
//        return ans;
//    }
//}