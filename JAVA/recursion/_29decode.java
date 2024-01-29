import java.util.HashSet;

public class _29decode{
    public static void main(String[] args) {
        String s="226";
        HashSet<String> set=new HashSet<>();
        group(s,set,"");
        int count=0;
        for(String i:set){
            if(isValid(i))count++;
        }
        System.out.println(count);
    }
    public static void group(String s,HashSet<String> set,String ans) {
        if(s.length()==0){
            if(ans.charAt(ans.length()-1)=='.')ans=ans.substring(0,ans.length()-1);
            set.add(ans);
            return;
        }

        group(s.substring(1), set, ans+s.charAt(0));
        group(s.substring(1), set, ans+s.charAt(0)+".");
    }
    public static boolean isValid(String s) {
        String words[]=s.split("\\.");

        for(String i:words){
            int no=Integer.parseInt(i);
            if(i.charAt(0)=='0'||no<=0||no>26)return false;
        }
        return true;
    }
}