package navercloud;

import java.util.Arrays;

/**
 * dp 내려가기랑 비슷하다.
 * 아래, 오른쪽으로만 이동이 가능한데, 오른쪽으로 가는데 비용, 왼쪽으로 가는데 비용이 존재해.
 * 그리고 칸마다 얻을 수 있는 일급이 있다.
 * 이때 가장 많은 돈을 얻을 수 있는 경우의 총 일급을 구하세요.
 */

public class Problem37 {

    private static int max = -1;

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.solution(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, 100 ,0));
    }

    public int solution(int[][] costs, int xcost, int ycost) {
        int[][] dp = new int[costs.length][costs[0].length];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -10000000);
        }

        /**
         * 왼쪽에서 오른쪽 순서로 진행하는 이유?
         * 어떤 특정 위치로 생각했을 때, 위, 왼쪽의 위치에서만 특정 위치에 도달할 수 있다.
         * 즉 다시 말하면 왼쪽에서 오른쪽 순서로 진행하게 되면 어떠한 특정 위치로 도달하기 전에 그 위치의 위, 왼쪽의 위치는 이미 모든 경우의 수에 대한 최댓값이 계산된 상태가 되기 때문에
         * 왼쪽에서 오른쪽 순서로 진행해야 한다.
         */
        dp[0][0] = costs[0][0];
        for(int i=0; i<costs.length; i++) {
            for(int j=0; j<costs[i].length; j++) {
                if(i+1 < costs.length)
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + costs[i+1][j] - ycost);
                if(j+1 < costs[0].length)
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + costs[i][j+1] - xcost);
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
