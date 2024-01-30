public class _34coinTakeMoneyNoOfWays {
    public static void main(String[] args) {
        int arr[]={1,2,5,10,2,7};
        int money=12;

        System.out.println(noOfWaysWeCanGiveMoneyUingTheCoinsInArray(arr,arr.length,money,0,0,""));
    }
    public static int noOfWaysWeCanGiveMoneyUingTheCoinsInArray(int[] arr,int n,int money,int i,int sum,String ans) {
        if (i == n || sum >= money) {
            if (sum == money) {
                System.out.print(ans + " ");
                return 1;
            }
            return 0;
        }

        // Exclude the current coin
        int count = noOfWaysWeCanGiveMoneyUingTheCoinsInArray(arr, n, money, i + 1, sum, ans);

        // Include the current coin
        count += noOfWaysWeCanGiveMoneyUingTheCoinsInArray(arr, n, money, i, sum + arr[i], ans + arr[i] + " ");
    
        return count;
    }
}
