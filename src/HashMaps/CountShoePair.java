package HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountShoePair {
    public static int countPairs(String[] shoes) {
        // HashMap to store the count of left and right shoes for each size
        HashMap<Integer, int[]> shoeMap = new HashMap<>();

        // Traverse through the array of shoes
        for (String shoe : shoes) {
            // Extract the shoe size and the orientation (L/R)
            int size = Integer.parseInt(shoe.substring(0, shoe.length() - 1)); // Shoe size
            char orientation = shoe.charAt(shoe.length() - 1); // 'L' or 'R'

            // Initialize the size in the map if not present
            shoeMap.putIfAbsent(size, new int[2]); // [0] for left, [1] for right

            // Increment the count of left or right shoes based on orientation
            if (orientation == 'L') {
                shoeMap.get(size)[0]++; // Increment left count
            } else {
                shoeMap.get(size)[1]++; // Increment right count
            }
        }

        System.out.println(Arrays.toString(shoeMap.get(8)));
        // Now count the pairs
        int pairs = 0;
        for (Map.Entry<Integer, int[]> entry : shoeMap.entrySet()) {
            int[] counts = entry.getValue();
            pairs += Math.min(counts[0], counts[1]); // Minimum of left and right shoes
        }

        return pairs;
    }

    public static void main(String[] args) {
        // Example input
        String[] shoes = {"7L", "7R", "8L", "8R", "8L","9R","9L"};

        // Call the function to count the pairs
        int result = countPairs(shoes);

        // Print the result
        System.out.println("result is "+result);
    }
}
