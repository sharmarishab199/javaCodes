import java.util.ArrayList;

public class _30longestIncSub {
    static int max=-1;
    public static void main(String[] args) {
        int arr[]={10, 22, 9, 33, 21, 50, 41, 60};
        ArrayList<String> list=new ArrayList<>();

        incSubsequence(arr,arr.length,0,list,"");

        System.out.println(max);
    }
    public static void incSubsequence(int arr[],int n,int idx, ArrayList<String> list,String ans) {
        if(idx==n){
            list.add(ans);
            String words[]=ans.split(" ");
            max=Math.max(max,words.length);
            return;
        }
        if(ans.length()==0){
            incSubsequence(arr, n,idx+1,list, ans+arr[idx]+" ");
        }
        if(ans.length()>0){
            int num=getLast(ans);
            if(num<arr[idx]){
                incSubsequence(arr, n, idx+1, list, ans+arr[idx]+" ");
            }
        }
        incSubsequence(arr, n, idx+1, list, ans);
    }

    public static int getLast(String a) {
        String words[]=a.split(" ");
        return Integer.parseInt(words[words.length-1]);
    }
}
