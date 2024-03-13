package GfgPracticeProblem;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr={7,4,0,9};
        System.out.println(trappingWater(arr,4));
    }
    static long trappingWater(int arr[], int n) {
        int[] lh = new int[n];        //to store left maximum height
        int[] rh = new int[n];        //to store right maximum height

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            lh[i] = Math.max(arr[i - 1], max);
            max = Math.max(max, arr[i]);
        }


        max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rh[i] = Math.max(arr[i + 1], max);
            max = Math.max(arr[i], max);
        }
        long ans = 0;
        long height = 0;

        for (int i = 0; i < n; i++) {
            height = Math.min(lh[i], rh[i]) - arr[i];

            if (height > 0) {
                ans += height;
            }
        }


        return ans;
    }
}
