public class _33noOfWays {
    public static void main(String[] args) {
        int n=14;
        System.out.println(ways(n,0));
    }
    public static int ways(int n,int i) {
       if(i==n)return 1;
       if(i>n)return 0;

       int op1=ways(n, i+1);
       int op2=ways(n, i+2);
       int op3=ways(n, i+3);

       return op1+op2+op3;
    }
}
