package GfgPracticeProblem;

//Input: str = "ccad"
//        Output: "aacd"
//        Explanation: In ccad, we choose a and c and after doing the replacement
//        operation once we get,
//        aacd and this is the lexicographically smallest string possible.

public class ChooseAndSwap {
    String choose_and_swap(String str) {
        int[] freq=new int[26];
        for(int i=0; i<str.length(); i++){
            freq[str.charAt(i)-'a']=1;
        }

        char c1='-';
        char c2='-';

        for(int i=0; i<str.length(); i++){
            int ch=str.charAt(i)-'a';
            c1=str.charAt(i);

            freq[ch]=-1;

            for(int j=0; j<ch;j++){
                if(freq[j]==1){
                    c2=(char) (j+'a');
                    break;
                }
            }

            if(c2 != '-') break;
        }
        if(c2=='-') return str;
        return replace(str,c1,c2);
    }
    String replace(String str,char c1,char c2){
        StringBuilder sb=new StringBuilder();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c1){
                sb.append(c2);
            }else if(str.charAt(i)==c2){
                sb.append(c1);
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
