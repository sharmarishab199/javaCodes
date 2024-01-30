import java.util.HashSet;

public class _32EvenOdd {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        String s="5,5,2,5,8";
        subsequence(s," ",set);
        int max=0;
        System.out.println(set);
        for(String i:set){
            if(check(i))max++;
        }

        System.out.println(max);
    }
    public static void subsequence(String s,String ans,HashSet<String> set) {

        int idx=s.indexOf(',');
        if (idx == -1) {
            ans = ans.trim();
            set.add(ans);
            if(ans.length()!=0){
                ans += " " + s;
                set.add(ans);
            }
        }
        
        if(idx!=-1){
            String ch=s.substring(0, idx);
            subsequence(s.substring(idx+1), ans+ch+' ', set);
            subsequence(s.substring(idx+1), ans, set);
        }
    }
    public static boolean check(String s) {
        if(s.length()==0)return false;
        else {
            String words[]=s.split(" ");

            int evenSum=0,oddSum=0;
            for(int i=0;i<words.length;i++){
                int num=Integer.parseInt(words[i]);
                if(i%2==0)evenSum+=num;
                else oddSum+=num;
            }

            if(oddSum==evenSum)return true;
        }
        return false;
    }
}
