package inflearn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Kruskal MST
 * Union-Find 활용
 * 간선과 비용이 주어질 때 모든 노드가 이어지는 최소 비용 경로를 구하시오
 *
 * 1. 모든 노드가 이어지는 -> n-1개의 간선을 가지고 있다.
 * 2. n-1개의 간선 -> 순환이 발생하면 안됨 (n개 이상의 간선이 되면 무조건 순환 발생)
 * 3. 순환이 발생하는 경우? 같은 집합의 노드끼리 연결되면 무조건 순환이 발생한다.
 */

public class Problem70 {

    public static void main(String[] args) {
        int[][] node;
        int v,e;

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        node = new int[e][3];
        for(int i=0; i<e; i++) {
            node[i][0] = sc.nextInt();
            node[i][1] = sc.nextInt();
            node[i][2] = sc.nextInt();
        }

        WonderLand wonderLand = new WonderLand(node, v, e);
        wonderLand.mainLogic();
    }
}

class WonderLand {

    private int[] unionNumbers = new int[26];
    private int[][] node;
    private int v,e;

    public WonderLand(int[][] node, int v, int e) {
        this.node = node;
        this.v = v;
        this.e = e;
    }

    /**
     * 집합에 포함시키는 함수
     * a의 루트 노드를 찾아서 b의 루트 노드 연결시켜준다.
     */
    private void union(int a, int b) {
        a=find(a);
        b=find(b);
        unionNumbers[a] = b;
    }

    /**
     * 무슨 집합에 속했는지 알아내는 함수
     */
    private int find(int v) {
        if(unionNumbers[v] == v) return unionNumbers[v];
        else return unionNumbers[v] = find(unionNumbers[v]);
    }

    void mainLogic() {
        int cost = 0;

        initializedUnionNumbers();
        sort();

        for(int i=0; i<node.length; i++) {
            int a = node[i][0];
            int b = node[i][1];
            int abCost = node[i][2];

            // 1. 둘이 같은 집합인지 확인한다.
            if(find(a) == find(b)) {
                continue;
            }
            else {
                // 같은 집합이 아니면 합친 후 비용을 추가한다.
                union(a, b);
                cost += abCost;
            }
        }

        System.out.println(cost);
    }

    void sort() {
        Arrays.sort(node, (o1, o2) -> {
            if(o1[2] > o2[2]) return 1;
            else if(o1[2] < o2[2]) return -1;
            else return 0;
        });
    }

    void initializedUnionNumbers() {
        for(int i=1; i<=v; i++) {
            unionNumbers[i] = i;
        }
    }
}

