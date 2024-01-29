public class _27knapSack2 {
    public static void main(String[] args) {
        int n=4;
        int arr[][]={{1,1},{3,4},{4,5},{5,7}};
        int weight=7;

        System.out.println(knap(n,arr,weight,0,0));
    }
    public static int knap(int n,int arr[][],int weight,int i,int ans) {
        if(i==n)return ans;
        
        int op1=knap(n, arr, weight, i+1, ans);
        int op2=-1;

        int diff=weight-arr[i][0];
        if(diff>=0){
            op2=knap(n, arr, weight-arr[i][0], i+1, ans+arr[i][1]);
        }

        return Math.max(op1,op2);
    }
//     4 
// 1 1 
// 3 4 
// 4 5 
// 5 7 
// 7 
}
