package junior.inflearn;

import java.util.Scanner;

/**
 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요. 출발점은 격 자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 ▣ 입력설명
 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 ▣ 출력설명
 첫 번째 줄에 경로의 가지수를 출력한다.
 */

public class Problem58 {

    public static void main(String[] args) {
        int[][] maze = new int[7][7];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        MazeSearch mazeSearch = new MazeSearch(maze);
        mazeSearch.DFS(0, 0);
        System.out.println("mazeSearch.cnt = " + mazeSearch.cnt);
    }
}

class MazeSearch {

    private int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int[][] maze;
    private boolean[][] isCheck;
    private int n;
    public int cnt = 0;

    public MazeSearch(int[][] maze) {
        this.maze = maze;
        this.n = maze.length;
        isCheck = new boolean[n][n];
        isCheck[0][0] = true;
    }

    void DFS(int left, int right) {
        if(left == n-1 && right == n-1) {
            cnt++;
            return;
        }

        for(int i=0; i<directions.length; i++) {
            int nextLeft = left + directions[i][0];
            int nextRight = right + directions[i][1];
            if(nextLeft < 0 || nextRight < 0 || nextLeft > n-1 || nextRight > n-1) continue;

            if(!isCheck[nextLeft][nextRight] && maze[nextLeft][nextRight] == 0) {
                isCheck[nextLeft][nextRight] = true;
                DFS(nextLeft, nextRight);
                isCheck[nextLeft][nextRight] = false;
            }
        }
    }
}
