import java.util.Arrays;

public class RotArr {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int rot=2;
        int[] temp=new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int index=(i+4)% arr.length;
//            System.out.print(index+"\t");
            temp[index]=arr[i];
        }

        System.out.println(Arrays.toString(temp));
    }
}
