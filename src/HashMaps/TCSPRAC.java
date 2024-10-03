package HashMaps;
import java.util.HashMap;
import java.util.Scanner;

public class TCSPRAC {
        public static void findMajorityElement(String[] arr, int N) {
            HashMap<String, Integer> freq = new HashMap<>();
            for (String n : arr) {
                freq.put(n,freq.getOrDefault(n,0)+1);
            }
            for (String key : freq.keySet()) {
                if (freq.get(key) >= N / 3) {
                    System.out.print(key + " ");
                }
            }
        }

        public static void findMajorityElementInt(int[] arr, int N) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num,freq.getOrDefault(num,0)+1);
            }
            for (int key : freq.keySet()) {
                if (freq.get(key) >= N / 3) {
                    System.out.print(key + " ");
                }
            }
        }

        // Case 1 If input format is [i1,i2,i3..]
        public static void inputArrayFormat() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter elements in format [e1,e2,e3]: ");
//          String input = scanner.nextLine().replaceAll("[\\[\\]]", "");
            String input=scanner.nextLine().replaceAll("[\\[\\]]","");
            String[] arr = input.split(",");
            findMajorityElement(arr, arr.length);
        }

        // Case 2 If input format is [1 2 4 5 .]
        public static void inputSpaceSeparated() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nCase 2: Enter space-separated elements: ");
            String input = scanner.nextLine();
            String[] strArr = input.split("\\s+");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            findMajorityElementInt(arr, arr.length);
        }

        public static void main(String[] args) {
//            inputArrayFormat();
            inputSpaceSeparated();
        }
}
