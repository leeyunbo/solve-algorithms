package junior.inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 가중치 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 최소비용을 출력하는 프로그램을 작성하세요.
 */

public class Problem60 {

    public static void main(String[] args) {
        int n, m;
        ArrayList<LinkedList<Edge>> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<=n; i++) list.add(new LinkedList<>());


        for(int i=0; i<m; i++) list.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));


        LeastCost2 leastCost = new LeastCost2(n, list);
        leastCost.DFS(1, 0);
        System.out.println(leastCost.cost);
    }
}

class LeastCost2 {

    public int cost = 654321234;
    private int n;
    private ArrayList<LinkedList<Edge>> list;
    private boolean[] isCheck;

    public LeastCost2(int n, ArrayList<LinkedList<Edge>> list) {
        this.n = n;
        this.list = list;
        isCheck = new boolean[n+1];
    }

    void DFS(int node, int total) {
        if(node == n) {
            cost = Math.min(cost, total);
            return;
        }

        for(Edge edge : list.get(node)) {
            if(isCheck[edge.end] == false) {
                isCheck[edge.end] = true;
                DFS(edge.end, total + edge.weight);
                isCheck[edge.end] = false;
            }
        }
    }
}

class Edge {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
