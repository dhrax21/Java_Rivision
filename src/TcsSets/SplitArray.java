package TcsSets;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr={8,2,4,5};

        System.out.println(canSplitArrayEqualAvg(arr));
    }

    public static boolean canSplitArrayEqualAvg(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        // Iterate over possible splits
        for (int i = 0; i < n - 1; i++) {
            leftSum += arr[i];  // Sum of the first subarray
            int rightSum = totalSum - leftSum;  // Sum of the second subarray

            int leftLen = i + 1;  // Length of the first subarray
            int rightLen = n - leftLen;  // Length of the second subarray

            // Check if cross multiplication condition holds
            if (leftSum * rightLen == rightSum * leftLen) {
                return true;  // Split found where the averages are equal
            }
        }

        return false;  // No split found
    }
}
