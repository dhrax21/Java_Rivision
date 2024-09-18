package CodeBeginners;

public class pattern {
    public static void main (String[] args) {

//        printTri(5,0);
        diam(5);
    }

    static void diam(int n){
        for(int i=0; i<2*n; i++){
            int cols=i>n ? 2*n-i : i;
            for(int s=0; s<n-cols; s++){
                System.out.print(" ");
            }
            for (int j=0; j<cols; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void printTri(int rows,int col){
        if(rows==0){
            return;
        }
        if(col<rows){
            printTri(rows,col+1);
            System.out.print("* ");

        }
        else{
            printTri(rows-1,0);
            System.out.println();
        }
    }
}
