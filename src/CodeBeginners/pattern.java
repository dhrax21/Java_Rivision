package CodeBeginners;

public class pattern {
    public static void main (String[] args) {

        printTri(5,0);
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
