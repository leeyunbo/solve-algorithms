package junior.dp;

/**
 * N개의 문제(점수, 푸는 시간)가 주어진다.
 * limit 시간 안에 문제를 풀어 얻을 수 있는 최고 점수를 구하시오.
 */

import java.util.Scanner;

public class Problem94 {

    public static void main(String[] args) {
        Problem[] problems;
        int limit, n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        limit = sc.nextInt();
        problems = new Problem[n];

        for(int i=0; i<n; i++) {
            problems[i] = new Problem(sc.nextInt(), sc.nextInt());
        }

        ProblemSolver problemSolver = new ProblemSolver(problems, limit);
        problemSolver.mainLogic();
    }
}

class ProblemSolver {

    private Problem[] problems;
    private int limit;
    private int[] dp;

    public ProblemSolver(Problem[] problems, int limit) {
        this.problems = problems;
        this.limit = limit;
        this.dp = new int[limit+1];
    }

    void mainLogic() {
        System.out.println(dp());
    }

    int dp() {
        for(int i=0; i<problems.length; i++) {
            for(int j=0; j<=limit; j++) {
                if(j>=problems[i].time) {
                   dp[j] = Math.max(dp[j], dp[j - problems[i].time] + problems[i].score);
                }
            }
        }

        return dp[limit];
    }
}

class Problem {
    int score;
    int time;
    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
