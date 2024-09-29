package HashMaps;

import java.util.HashMap;

public class LargestSubArrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int N= arr.length;
        int K = 15;
        HashMap<Integer, Integer> sum_map = new HashMap<>();
        int current_sum = 0; // This will store the running prefix sum
        int max_length = 0;  // To store the maximum length of sub-array with sum equal to K

    // Iterate over the array
        for (int i = 0; i < N; i++) {
        // Add the current element to the running sum
        current_sum +=arr[i];

        // Case 1: Check if the sum from the start to the current index equals K
        if (current_sum == K) {
            max_length = i + 1; // The whole array up to i is the sub-array
        }

        // Case 2: Check if (current_sum - K) exists in the map
        if (sum_map.containsKey(current_sum - K)) {
            // Calculate the length of the sub-array
            int length = i - sum_map.get(current_sum - K);
            max_length = Math.max(max_length, length);
        }

        // Case 3: Store the current_sum in the map if it hasn't been stored already
        if (!sum_map.containsKey(current_sum)) {
            sum_map.put(current_sum, i);
        }
    }

    // Return the maximum length of the sub-array with sum K
        System.out.println(max_length);
   }
}
