package junior.inflearn;

import java.util.Scanner;

/**
 * 경로 탐색 (DFS)
 * 방향 그래프가 주어지면, 1부터 N까지 가는 모든 경로의 가지 수를 출력하세요.
 */

public class Problem57 {

    public static void main(String[] args) {
        int n, m;
        int[][] adj;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            adj[sc.nextInt()][sc.nextInt()] = 1;
        }

        Navigator navigator = new Navigator(adj, n);
        navigator.D(1);
        System.out.println("navigator.cnt = " + navigator.cnt);


    }
}

class Navigator {

    private boolean[] isCheck;
    private int[][] adj;
    public int cnt = 0;
    private int n;

    public Navigator(int[][] adj, int n) {
        this.adj = adj;
        this.n = n;
        isCheck = new boolean[n+1];
        isCheck[1] = true;
    }

    void D(int node) {
        if(node == n) {
            cnt++;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(adj[node][i] == 1 && !isCheck[i]) {
                isCheck[i] = true;
                D(i);
                isCheck[i] = false;
            }
        }
    }


}
