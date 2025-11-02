package leetcode_160;

public class MergeSortedArray {


    //start from the last index of both arrays
    //compare the elements, and put the larger one at the end of nums1(m+n-1)
    // move pointer backwords
    //if elements remain in nums2,copy them into nums1

    public static void main(String[] args) {

    int[] nums1={1,2,3};
    int[] nums2={2,4,6};

    int n=nums1.length;
    int m=nums2.length;

    int i=m-1;
    int j=n-1;
    int k=m+n-1;

        while(i>= 0 && j>=0){
          if(nums1[i] > nums2[j]){
            nums1[k--]=nums1[i--];
        }else{
            nums1[k--]=nums2[j--];
        }
    }

        while(j>=0){
        nums1[k--]=nums2[j--];
    }
}
}
