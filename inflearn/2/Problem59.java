package inflearn;

import java.util.Scanner;

/**
 가중치 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 최소비용을 출력하는 프로그램을 작성하세요.
 ▣ 입력설명
 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연 결정보가 주어진다.
 ▣ 출력설명 최소비용을 출력합니다.
 */

public class Problem59 {

    public static void main(String[] args) {
        int n, m;
        int[][] edges;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            edges[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        LeastCost leastCost = new LeastCost(n, edges);
        leastCost.DFS(1, 0);
        System.out.println(leastCost.cost);
    }
}

class LeastCost {

    private int n;
    private int[][] edges;
    private boolean[] isCheck;

    public int cost = 654321654;

    public LeastCost(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        isCheck = new boolean[n+1];
        isCheck[1] = true;
    }

    void DFS(int node, int total) {
        if(node == n) {
            cost = Math.min(cost, total);
            return;
        }

        for(int i=1; i<=n; i++) {
            if(edges[node][i] > 0 && isCheck[i] == false) {
                isCheck[i] = true;
                DFS(i, total + edges[node][i]);
                isCheck[i] = false;
            }
        }
    }
}
