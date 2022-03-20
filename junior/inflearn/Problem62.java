package junior.inflearn;

/**
 * 1번 정점에서 모든 정점들로 갈 수 있는 최단 거리를 구하세요.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem62 {

    public static void main(String[] args) {

        int n,m;
        Node[] nodes;
        ArrayList<LinkedList<Integer>> tree = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        nodes = new Node[n+1];
        for(int i=0; i<=n; i++) {
            tree.add(new LinkedList<>());
            nodes[i] = new Node();
        }

        for(int i=0; i<m; i++) {
            tree.get(sc.nextInt()).add(sc.nextInt());
        }

        ShortestPath shortestPath = new ShortestPath(tree, n, nodes);
        shortestPath.BFS();
        shortestPath.printDistance();
    }
}

class ShortestPath {

    private int n;
    private ArrayList<LinkedList<Integer>> tree;
    public Node[] nodes;
    public int[] distance;

    public ShortestPath(ArrayList<LinkedList<Integer>> tree, int n, Node[] nodes) {
        this.n = n;
        this.tree = tree;
        this.nodes = nodes;
        distance = new int[n+1];
    }

    void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int start = queue.poll();

            for(int end : tree.get(start)) {
                if(nodes[end].isCheck) continue;

                nodes[end].isCheck = true;
                queue.add(end);
                nodes[end].level = nodes[start].level + 1;
            }
        }
    }

    void printDistance() {
        for(int i=2; i<=n; i++) {
            System.out.println(i + " : " + nodes[i].level);
        }
    }
}

class Node {
    public int level = 0;
    public boolean isCheck = false;
}
