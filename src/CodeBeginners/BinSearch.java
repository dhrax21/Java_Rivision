package CodeBeginners;

public class BinSearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};

        System.out.println(binSearch(arr,9));
    }

    private static int binSearch(int[] arr, int key) {
           return helper(arr,key,0,arr.length-1);
    }

    private static int helper(int[] arr, int key, int start, int end) {

        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return helper(arr, key, start, mid - 1);
            }
            return helper(arr, key, mid+1, end);

        }
        return -1;
    }
}
