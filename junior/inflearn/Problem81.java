package junior.inflearn;

/**
 * 토마토 밭이 주어진다. (익은 토마토 = 1, 안익은 토마토 = 0, 그 외 = -1)
 * 익은 토마토 기준으로 위, 아래, 오른쪽, 왼쪽 토마토가 익는다고 한다.
 * 이때, 밭에 있는 모든 토마토가 익는데 걸리는 최소 시간을 구하시오. (익은 토마토의 인접 토마토가 익는 시간은 하루라고 한다.)
 *
 * 만약 토마토가 모두 익을 수 없다면 -1을 리턴하고, 모든 토마토가 애초에 익은 상태라면 0을 리턴하시오.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem81 {

    public static void main(String[] args) {
        Queue<Tomato> queue = new LinkedList<>();
        int[][] tomatoes;
        int M, N;

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        tomatoes = new int[M][N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                tomatoes[i][j] = sc.nextInt();
                if(tomatoes[i][j] == 1) {
                    queue.add(new Tomato(i, j, 1));
                }
            }
        }


        TomatoSimulator tomatoSimulator = new TomatoSimulator(queue, tomatoes, M, N);
        tomatoSimulator.mainLogic();
    }
}

class TomatoSimulator {

    private Queue<Tomato> queue;
    private int level = 0, M, N;
    private int[][] tomatoes;
    private int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public TomatoSimulator(Queue<Tomato> queue, int[][] tomatoes, int M, int N) {
        this.queue = queue;
        this.tomatoes = tomatoes;
        this.M = M;
        this.N = N;
    }

    void mainLogic() {
        System.out.println(BFS());
    }

    int BFS() {

        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for(int i=0; i<dir.length; i++) {
                int nX = tomato.x + dir[i][0];
                int nY = tomato.y + dir[i][1];
                if(nX < 0 || nY < 0 || nX >= M || nY >= N) continue;
                if(tomatoes[nX][nY] == 0) {
                    level = tomatoes[tomato.x][tomato.y] + 1;
                    tomatoes[nX][nY] = level;
                    queue.add(new Tomato(nX, nY, level));
                }
            }
        }

        if(check()) return level-1;
        else return -1;
    }

    boolean check() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(tomatoes[i][j] == 0) return false;
            }
        }

        return true;
    }
}

class Tomato {
    int x;
    int y;
    int data;

    public Tomato(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }
}
