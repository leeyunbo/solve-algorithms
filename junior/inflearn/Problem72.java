package junior.inflearn;

import java.util.*;

/**
 * 가중치 그래프가 주어질 때, 1에서 갈 수 있는 모든 정점으로의 최소 거리비용을 출력하세요.
 *
 * 다익스트라 알고리즘 이용!
 * 1. 가장 작은 비용을 가지고 있는 목적지를 선택한다. (들렸음을 체크한다.)
 * 2. 그 목적지에서 뻗어지는 노드들의 비용을 계산한다. ( Relax 과정, cost[n] = Math.min(cost[n], cost[before] + link.cost)
 * 3.
 *
 * 우선순위 큐를 이용하여 무조건 최솟값을 선택하는 이유는?
 * 1   2    3    4    5    6
 * 0  12    4   INF  INF  INF
 * 일 때, 3을 선택했다고 해보자. 그러면 3의 cost가 갱신될 일이 있을까? -> boolean 배열이 따로 필요 없다!
 * 없다! 1에서 4, 5, 6을 접근하기 위해서는 1에서 이어지는 2나 3을 무조건 거쳐야 한다. 그런데 여기서 3이 최소 비용을 가지고 있기 떄문에 3의 비용은 어떠한 경우에도 갱신 될 일이 없다.
 * (모든 비용이 양수이기 때문에!)
 *
 */

public class Problem72 {

    public static void main(String[] args) {
        ArrayList<LinkedList<DijkstraLink>> links = new ArrayList<>();
        int v,e;

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=0; i<=v; i++) {
            links.add(new LinkedList<>());
        }

        for(int i=0; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            links.get(a).add(new DijkstraLink(b, c));
        }

        Dijkstra dijkstra = new Dijkstra(links, v);
        dijkstra.calculateShortestPath();
    }
}


class Dijkstra {

    private int v;
    private ArrayList<LinkedList<DijkstraLink>> links;
    private int[] costs = new int[21];

    public Dijkstra(ArrayList<LinkedList<DijkstraLink>> links, int v) {
        this.links = links;
        this.v = v;
        Arrays.fill(costs, 654321);
    }

    void calculateShortestPath() {
        // 가장 작은 비용을 가진 노드를 다음 경로로 선택하도록 한다.
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(costs[o1] < costs[o2]) return -1;
            else if(costs[o1] > costs[o2]) return 1;
            else return 0;
        });
        costs[1] = 0;
        queue.add(1);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (DijkstraLink next : links.get(now)) {
                if(costs[next.number] > costs[now] + next.cost) {
                    costs[next.number] = costs[now] + next.cost;
                    queue.add(next.number);
                }
            }
        }

        for(int i=2; i<=v; i++) {
            if(costs[i] == 654321) System.out.print("impossible ");
            else System.out.print(costs[i] + " ");
        }
    }
}

class DijkstraLink {
    int number;
    int cost;

    public DijkstraLink(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}

