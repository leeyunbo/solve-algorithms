package junior.inflearn;

/**
 *  nXn 지도가 주어진다. 섬의 영역은 1로 표시되어 상하좌우, 대각선으로 연결되어 있다.
 *  이때, 섬의 갯수를 출력하시오.
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem79 {

    public static void main(String[] args) {
        int[][] map;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Island island = new Island(map, n);
        island.mainLogic();
    }
}

class Island {

    private int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    private int[][] map;
    private int n;

    public Island(int[][] map, int n) {
        this.map = map;
        this.n = n;
    }

    void mainLogic() {
        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    BFS(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        while(!queue.isEmpty()) {
            Node tNode = queue.poll();
            for(int d=0; d<dir.length; d++) {
                int nX = tNode.x + dir[d][0];
                int nY = tNode.y + dir[d][1];
                if(nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                if(map[nX][nY] == 1) {
                    queue.add(new Node(nX, nY));
                    map[nX][nY] = 0;
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

