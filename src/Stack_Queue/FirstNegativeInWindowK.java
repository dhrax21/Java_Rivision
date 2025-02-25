package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInWindowK {
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        int N=arr.length;
        List<Integer> ans=new ArrayList<>(N-k+1);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]<0) q.add(i);
        }

        for(int i=0; i<N-k+1; i++){
            if(!q.isEmpty() && q.peek()<i) q.remove();

            if(!q.isEmpty() && q.peek()<i+k-1)
                ans.add(arr[q.peek()]);
            else if(q.isEmpty())
                ans.add(0);
            else
                ans.add(0);
        }

        return ans;
    }
}
