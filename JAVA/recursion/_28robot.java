public class _28robot {
    public static void main(String[] args) {
        int n = 3, m = 4;
        int arr[][] = {
            {2 ,5 ,1 ,3 },
            {3, 7 ,2 ,8},
            {4, 8 ,3 ,4},
        };
        System.out.println(pathExplorer(n, m, 0, 0, arr, 0));
    }

    public static int pathExplorer(int n, int m, int i, int j, int[][] arr, int ans) {
        if(i==n-1&&j==m-1)return ans+arr[i][j];

        if(i==n||j==m)return -1;

        int op1=pathExplorer(n, m, i+1, j, arr, ans+arr[i][j]);
        int op2=pathExplorer(n, m, i, j+1, arr, ans+arr[i][j]);
        return Math.max(op1, op2);
    }
}
