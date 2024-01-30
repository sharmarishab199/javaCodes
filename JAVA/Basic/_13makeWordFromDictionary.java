public class _13makeWordFromDictionary {
    public static void main(String[] args) {
        String s="applepie";
        int n=5;
        String words[]={"apple","p","applep","ap","pie"};

        System.out.println(check(words,n,s,0,""));
    }
    public static boolean check(String[] words,int n,String s,int i,String ans) {
        if(i==n)return false;

        String added=ans+words[i];

        if(added.compareTo(s)==0){
            System.out.println(added);
            return true;
        }

        boolean op1=check(words, n, s, i+1, added);
        boolean op2=check(words, n, s, i+1, ans);

        return op1||op2;
    }
}
