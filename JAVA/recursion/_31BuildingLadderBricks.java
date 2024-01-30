public class _31BuildingLadderBricks {
    public static void main(String[] args) {
        int arr[]={4,2,7,6,9,14,12};
        int bricks=5;
        int ladders=1;

        System.out.println(recurs(arr,arr.length,bricks,ladders,0));
    }

    public static int recurs(int arr[],int n,int bricks,int ladders,int idx){
        if(idx==arr.length-1){
            return idx;
        }

        int op1=-1,op2=-1,op3=-1;
        if(arr[idx]>=arr[idx+1])
            op1=recurs(arr, n, bricks, ladders, idx+1);

        else{
            int diff=arr[idx+1]-arr[idx];

            op2 = (bricks >= diff) ? recurs(arr,n, bricks - diff, ladders, idx + 1) : idx;
            
            op3 = (ladders > 0) ? recurs(arr,n, bricks, ladders - 1, idx + 1) : idx;
        }

        System.out.println("at idx "+idx+" option is "+op1+" "+op2+" "+op3);

        return Math.max(op1,Math.max(op2,op3));
    }
}
