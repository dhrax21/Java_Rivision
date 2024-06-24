package BitManipulation;

public class SetKthBit {
    static int setKthBit(int N,int K){
        int bitMask=(1<<K);         // used for creating mask
        return (N|bitMask);
    }
}
