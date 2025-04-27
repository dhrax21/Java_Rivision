package AdvancedCodes;

import java.util.ArrayList;
import java.util.HashSet;

//Given a binary matrix your task is to find all unique rows of the
// given matrix in the order of their appearance in the matrix.
public class UniqueRows {
    public static void main(String[] args) {
        int[][] a={{1,1,0,1}
        ,{1,0,0,1},{1,1,0,1}};

        int r=a.length;
        int c=a[1].length;

        System.out.println(uniqueRow(a,r,c));

    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        ArrayList<ArrayList<Integer>> vector=new ArrayList<>();

        HashSet<String> st=new HashSet<>();

        //iterating over the matrix

        for(int i=0; i<r;i++){
            StringBuilder curr= new StringBuilder();

            for(int j=0; j<c; j++){
                curr.append('0'+a[i][j]);
            }
            //adding the rows in hashset for checking uniqueness in future
            st.add(curr.toString());
        }

        // iterating again

        for(int i=0; i<r; i++){
            StringBuilder curr2=new StringBuilder();

            for(int j=0; j<c; j++){
                curr2.append('0'+a[i][j]);
            }

            if(st.contains(curr2.toString())){
                st.remove(curr2.toString());
                ArrayList<Integer> demo=new ArrayList<>();
                for(int j=0; j<c; j++){
                    demo.add(a[i][j]);
                }
                vector.add(demo);
            }
        }




        return vector;
    }


}
