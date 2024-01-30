import java.util.ArrayList;

public class _12binaryRepresentation {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        int n=5;
        //System.out.println(binary(0,"",list,0));

        int arr[]=new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=binary(i,"", list, 0);
        }
        for(int i:arr)System.out.println(i);
        //System.out.println(list);
    }
    public static int binary(int n,String ans,ArrayList<String> list,int count) {
        if(n==0)return 0;//exception
        if(n==1){
            count+=1;
            list.add(1+ans);
            return count;
        }
        int rem=n%2;
        if(rem==1)count+=1;
        return binary(n/2,rem+ans,list,count);
    }
}
