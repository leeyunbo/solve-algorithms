package inflearn;

import java.util.*;

/**
 * Prim MST
 * Union-Find 활용
 * 간선과 비용이 주어질 때 모든 노드가 이어지는 최소 비용 경로를 구하시오
 *
 * 1. 모든 노드가 이어지는 최소 비용 -> n-1개의 간선을 가지고 있다.
 * 2. n-1개의 간선 -> 순환이 발생하면 안됨 (n개 이상의 간선이 되면 무조건 순환 발생)
 * 3. 순환이 발생하는 경우? 같은 집합의 노드끼리 연결되면 무조건 순환이 발생한다.
 *
 * Prim 알고리즘
 * 1. 임의의 정점 선택, 그래프에 하나씩 추가하여 n개가 되면 완성
 * 2. 임의의 정점에서 특정 노드(n) 까지 비용이 c라고 할 때, (n,c)로 표현하고 우선순위 큐에 넣는다. (한번 들렸던 노드는 제외한다) 
 * 3. 가장 작은 비용을 가진 정점을 집합에 추가하고, 비용을 추가한다. 그리고 추가한 정점 기준으로 2번을 반복한다. 
 * 
 * Kruskal 알고리즘
 * 1. 가장 작은 비용을 가진 간선 선택, 선택하더라도 순환을 방지, 간선이 n-1개로 이루어지면 그래프 완성
 */

public class Problem71 {

    public static void main(String[] args) {
        ArrayList<LinkedList<NodePrim>> adjList = new ArrayList<>();
        int v,e;

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=0; i<=v; i++) {
            adjList.add(new LinkedList<>());
        }

        for(int i=0; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adjList.get(a).add(new NodePrim(b, c));
            adjList.get(b).add(new NodePrim(a, c));

        }

        WonderLandPrimMST wonderLand = new WonderLandPrimMST(adjList);
        wonderLand.mainLogic();
    }
}

class WonderLandPrimMST {

    private PriorityQueue<NodePrim> priorityQueue = new PriorityQueue<>((o1, o2) -> {
        if(o1.cost < o2.cost) return -1;
        else if(o1.cost > o2.cost) return 1;
        else return 0;
    });
    private ArrayList<LinkedList<NodePrim>> adjList;
    private boolean[] check = new boolean[26];

    public WonderLandPrimMST(ArrayList<LinkedList<NodePrim>> adjList) {
        this.adjList = adjList;
    }

    void mainLogic() {
        int cost = 0;

        priorityQueue.add(new NodePrim(1, 0));
        while(!priorityQueue.isEmpty()) {
            // 가장 작은 노드가 들렸던 노드가 아니라면 연결시켜준다.
            NodePrim next = priorityQueue.poll();
            if (check[next.number] == false) {
                check[next.number] = true;
                cost += next.cost;
                for (NodePrim node : adjList.get(next.number)) {
                    priorityQueue.add(node);
                }
            }
        }

        System.out.println(cost);
    }
}

class NodePrim {
    int number;
    int cost;

    public NodePrim(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}
