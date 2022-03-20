package junior.dp;

/**
 * 왼쪽의 번호와 오른쪽의 번호가 주어질 때 번호끼리 선으로 연결을 해야한다.
 * 선끼리 안 겹쳐지는 상태로 최대로 연결할 수 있는 수는 몇인가?
 */

import java.util.Arrays;
import java.util.Scanner;

public class Problem88 {

    public static void main(String[] args) {
        int n;
        int[] locations;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        locations = new int[101];
        for(int i=1; i<=n; i++) {
            locations[sc.nextInt()] = i;
        }

        LineConnect lineConnect = new LineConnect(locations);
        lineConnect.mainLogic();
    }
}


class LineConnect {

    private int[] locations;
    private int[] dp;

    public LineConnect(int[] locations) {
        this.locations = locations;
        dp = new int[locations.length+1];
        Arrays.fill(dp, 1);
    }

    void mainLogic() {
        System.out.println(dp());
    }

    int dp() {
        for(int i=2; i<=locations.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(locations[i] > locations[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        return dp[locations.length];
    }
}
