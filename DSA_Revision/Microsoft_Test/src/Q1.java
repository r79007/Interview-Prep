import java.util.HashSet;
import java.util.Locale;

public class Q1 {

    public static int func(String S){

        int[] commonArr={0, 1};

        int minSubstr = commonArr[0];

        if(S.length()!=0){
            minSubstr = commonArr[1];
        }

        int l = S.length();

        HashSet<Character> set = new HashSet<>();

        for(int i=commonArr[0];i<l;i++){
            if(set.contains(S.charAt(i))){
                minSubstr++;
                set.clear();
            }
            set.add(S.charAt(i));
        }

        return minSubstr;

    }

    public static void main(String[] args) {
        int n = func("abacdec");
        System.out.println(n);
    }

}
