import java.util.ArrayList;

public class _12symmetricNo {
    static int max=0;
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        //symmetric("1", list);
        int low=23,high=900;
        for(int i=low;i<=high;i++){
            String s=""+i;
            if(symmetric(s, list)&&s.length()%2==0){
                max++;
            }
        }
        System.out.println(list);
        System.out.println(max);
    }
    public static boolean symmetric(String s,ArrayList<String> list) {
        int n=s.length()/2;
        int firstHalf=0;
        int secondHalf=0;

        for(int i=0;i<n;i++){
           firstHalf+=Integer.parseInt(s.charAt(i)+"");
           secondHalf+=Integer.parseInt(s.charAt(i+n)+"");
        }

        if(firstHalf==secondHalf){
            list.add(s);
            return true;
        }

        return false;
    }
}
