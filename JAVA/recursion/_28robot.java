public class _28robot {
    public static void main(String[] args) {
        int n = 2, m = 1;
        int arr[][] = {
            {14},
            {52}
        };
        int visited[][] = new int[n][m];
        System.out.println(pathExplorer(n, m, 0, 0, arr, visited, arr[0][0]));
    }

    public static int pathExplorer(int n, int m, int i, int j, int[][] arr, int[][] visited, int ans) {
        if (i == n - 1 && j == m - 1) {
            visited[i][j] = 1;
            System.out.println(ans);
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < m; v++) {
                    System.out.print(visited[u][v]);
                }
                System.out.println();
            }
            System.out.println("*");
            return ans;
        }

        if (i >= n || j >= m || visited[i][j] == 1) return 0;

        visited[i][j] = 1;

        int op1 = pathExplorer(n, m, i, j + 1, arr, visited, ans + arr[i][j]);
        int op2 = pathExplorer(n, m, i + 1, j, arr, visited, ans + arr[i][j]);

        visited[i][j] = 0;

        return Math.max(op1, op2);
    }
}
