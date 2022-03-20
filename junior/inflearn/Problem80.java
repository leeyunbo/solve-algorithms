package junior.inflearn;

/**
 * 7x7의 맵이 주어진다. 0이 길이고 1이 벽이라고 할 때 (0,0) 에서 (6,6)까지 갈 수 있는 최단 거리를 구하시오.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem80 {

    public static void main(String[] args) {
        int[][] map = new int[7][7];

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        MazeRunner mazeRunner = new MazeRunner(map);
        mazeRunner.mainLogic();
    }
}


class MazeRunner {

    private int[][] map;
    private int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public MazeRunner(int[][] map) {
        this.map = map;
    }

    void mainLogic() {
        int result = BFS(0,0);
        System.out.println(result);
    }

    int BFS(int sX, int sY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sX, sY, 0));

        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            for(int i=0; i<dir.length; i++) {
                int nX = tmp.x + dir[i][0];
                int nY = tmp.y + dir[i][1];
                if(nX < 0 || nY < 0 || nX > 6 || nY > 6) continue;
                if(nX == 6 && nY == 6) return tmp.level+1;
                if(map[nX][nY] == 0) {
                    queue.add(new Node(nX, nY, tmp.level+1));
                    map[nX][nY] = 1;
                }
            }
        }

        return -1;
    }


    class Node {
        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }


}
