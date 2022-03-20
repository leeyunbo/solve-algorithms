package junior.inflearn;

/*
세종대왕은 현수에게 현수가 다스릴 수 있는 영지를 하사하기로 했다. 전체 땅은 사각형으로 표시된다.
그 사각형의 땅 중에서 세종대왕이 현수가 다스릴 수 있는 땅의 크기(세로의 길이와 가 로의 길이)를 정해주면 전체 땅 중에서 그 크기의 땅의 위치를 현수가 정하면 되는 것이다.
전체 땅은 사각형의 모양의 격자로 되어 있으며,그 사각형 땅 안에는 많은 오렌지 나무가 심 겨져 있다.
현수는 오렌지를 무척 좋아하여 오렌지 나무가 가장 많이 포함되는 지역을 선택하 고 싶어 한다.
현수가 얻을 수 있는 영지의 오렌지 나무 최대 개수를 출력하는 프로그램을 작 성하세요.
다음과 같은 땅의 정보가 주어지고, 현수가 하사받을 크기가, 가로 2, 세로 3의 크 기이면 가장 많은 오렌지 나무가 있는 영지는 총 오렌지 나무의 개수가 16인 3행 4열부터 시작하는 구역이다.
*/

import java.util.Scanner;

public class Problem45 {

    public static void main(String[] args) {
        int mH, mW, tH, tW;
        int[][] map;

        Scanner sc = new Scanner(System.in);
        mH = sc.nextInt();
        mW = sc.nextInt();

        map = new int[mH+1][mW+1];
        for(int i=1; i<=mH; i++) {
            for(int j=1; j<=mW; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        tH = sc.nextInt();
        tW = sc.nextInt();

        DpTerritorySelector territorySelector = new DpTerritorySelector(mH, mW, tH, tW, map);
        territorySelector.mainLogic();
    }
}

class DpTerritorySelector {

    private int tH;
    private int tW;
    private int mH;
    private int mW;
    private int[][] map;
    private int[][] dp;

    public DpTerritorySelector(int mH, int mW, int tH, int tW, int[][] map) {
        this.tH = tH;
        this.tW = tW;
        this.mH = mH;
        this.mW = mW;
        this.map = map;
    }

    void initializedTable() {
        dp = new int[mH+1][mW+1];

        for(int i=1; i<=mH; i++) {
            for(int j=1; j<=mW; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + map[i][j];
            }
        }
    }

    void mainLogic() {
        int answer = 0;

        initializedTable();
        for(int i=tH+1; i<=mH; i++) {
            for(int j=tW+1; j<=mW; j++) {
                answer = Math.max(answer, dp[i][j] - (dp[i][j-tW] + dp[i-tH][j]) + dp[i-tH][j-tW]);
            }
        }

        System.out.println("answer = " + answer);
    }
}
