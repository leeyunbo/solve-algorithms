package junior.inflearn;

import java.util.Scanner;

/**
 * 현수는 N+1일날 휴가를 떠나기 위해 남은 N일 동안 강의를 통해 휴가비를 벌어 들이려고 한다.
 * 걸리는 날수 T와 비용 P로 이루어진 강의 리스트가 주어질 때 현수가 휴가비를 가장 많이 벌 수 있는 강의 계획을 구하는 프로그램을 작성하시오.
 *
 * 첫째줄에 N이 주어지고, 나머지 N줄에 소요 일수 비용 이 주어진다.
 */

public class Problem74 {

    public static void main(String[] args) {
        int n;
        int[][] lectures;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lectures = new int[n+1][2];

        for(int i=1; i<=n; i++) {
            lectures[i][0] = sc.nextInt();
            lectures[i][1] = sc.nextInt();
        }

        Holiday holiday = new Holiday(n, lectures);
        holiday.mainLogic();
    }
}

class Holiday {

    private int n;
    private int[][] lectures;
    private int bestCost = 0;

    public Holiday(int n, int[][] lectures) {
        this.n = n;
        this.lectures = lectures;
    }

    void mainLogic() {
        createBestPlan(1, 0);
        System.out.println(bestCost);
    }

    void createBestPlan(int day, int cost) {
        if(day == n+1) {
            bestCost = Math.max(cost, bestCost);
            return;
        }

        // 선택되지 않은 경우
        createBestPlan(day + 1, cost);
        // 선택된 경우
        if(day + lectures[day][0] <= n+1)
            createBestPlan(day + lectures[day][0], cost + lectures[day][1]);
    }
}
