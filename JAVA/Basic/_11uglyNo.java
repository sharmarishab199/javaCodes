public class _11uglyNo{
    public static void main(String[] args) {
        //an ugly no if 2,3,5 only are its factor
        int n=12;
        System.out.println(factors(n));
    }
    public static boolean factors(int n) {
        int i=2;
        while(n!=1){
            if(n%i==0){
                if(i!=2&&i!=3&&i!=5){
                    return false;
                };
                n/=i;
            }else{
                i++;
            }
        }
        return true;
    }
}