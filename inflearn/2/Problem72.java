package inflearn2;

/**
 * 벨만 포드 알고리즘
 * N개의 도시가 주어지고, 각 도시들을 연결하는 도로와 비용이 주어질 때 1번 도시에서 다른 도시로 이동하는데 쓰이는 최소 비용을 모두 구하세요.
 *
 * 1,2.....v-1개의 간선으로 이루어진 경로를 순서대로 구한다.
 * 2개의 간선으로 이루어진 경로는 1개의 간선으로 이루어진 경로를 이용한다 (Optimal Substructure 구조)
 * 즉, n개의 간선으로 이루어진 경로를 구할 때는 n-1개의 간선으로 이루어진 경로를 구한다.
 *
 * 만약 p(u,v)가 있으면 p(u,v) = 1이라고 가정해보자 .
 * u -> s -> v가 가능하다면
 * p(u,v) = p(u,s) -> w(s,v) 이다.
 * 따라서 p(u,v)를 구할 때 p(u,s)를 이용하여 문제를 해결할 수 있다.
 *
 * 일차원 배열로 해결할 수 있는 이유는 앞으로 진행되면서 어차피 dist[간선의수-1][목적지]와 dist[간선의수][목적지]를 비교하므로
 * dist[목적지](dist[간선의수-1][목적지]) vs dist[출발지] + w[출발지,목적지]를 이용하여 게산하면 된다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Problem73 {

    public static void main(String[] args) {
        ArrayList<Edge> links = new ArrayList<>();
        int v,e;

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=0; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            links.add(new Edge(a, b, c));
        }

        BellmanFord bellmanFord = new BellmanFord(links, v, e);
        bellmanFord.getMinimumPath();
    }
}

class BellmanFord {

    private final int INF = 6543210;
    private int[] dist;
    private ArrayList<Edge> links;
    private int v;
    private int e;

    public BellmanFord(ArrayList<Edge> links, int v, int e) {
        this.links = links;
        this.v = v;
        this.e = e;
        dist = new int[v+1];
        for(int i=1; i<=v; i++) {
            dist[i] = INF;
        }
    }

    void getMinimumPath() {
        dist[1] = 0;
        for(int i=1; i<v; i++) {
            for (Edge link : links) {
                if (dist[link.s] != INF && dist[link.s] + link.w < dist[link.e]) {
                    dist[link.e] = dist[link.s] + link.w;
                }
            }
        }

        for (Edge link : links) {
            if (dist[link.s] != INF && dist[link.s] + link.w < dist[link.e]) {
                System.out.println("음의 사이클 존재");
                return;
            }
        }

        for(int i=2; i<=v; i++) {
            if(dist[i] != INF) System.out.println(i + " : " + dist[i]);
            else System.out.println(i + " : impossible");
        }
    }
}

class Edge {
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
