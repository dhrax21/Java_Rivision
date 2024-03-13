package AdvancedCodes;

public class DiceCombination
{
    public static void main(String[] args) {
        dice("",6);
    }

    private static void dice(String s, int target) {

        if(target==0){
            System.out.print(s+"\t");
            return;
        }
        for(int i=1; i<=6 && i<=target; i++){
            dice(s+i,target-i);
        }
    }
}
