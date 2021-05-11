package inflearn;

/*
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자 판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 */

import java.util.Scanner;

public class Problem42 {

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

        MountainCounter mountainCounter = new MountainCounter(map, n);
        mountainCounter.mainLogic();
    }
}

class MountainCounter {

    int n;
    int[][] map;
    int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public MountainCounter(int[][] map, int n) {
        this.map = map;
        this.n = n;
    }

    void mainLogic() {
        int answer = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer += isMountain(i, j);
            }
        }

        System.out.println("answer = " + answer);
    }

    int isMountain(int left, int right) {
        for(int i=0; i<direction.length; i++) {
            int nLeft = left + direction[i][0];
            int nRight = right + direction[i][1];

            if(nLeft < 0 || nRight < 0 || nLeft > n-1 || nRight > n-1) continue;
            if(map[nLeft][nRight] > map[left][right]) return 0;
        }

        return 1;
    }

}
