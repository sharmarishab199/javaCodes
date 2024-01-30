public class _35stairCase {
    public static void main(String[] args) {
        int n=13;
        System.out.println(stairs(n));
    }
    public static int stairs(int n) {
        if(n==0)return 1;
        if(n<0)return 0;
        
        int count=0;
        count+=stairs(n-1);
        count+=stairs(n-2);

        return count;
    }
}
