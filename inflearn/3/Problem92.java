package dp;

/**
 * 무게와 가치가 적혀져 있는 가방 n개가 있다.
 * 최대 무게 Limit 만큼 가방을 들 수 있을 때 가장 높은 가치를 가질 수 있는 경우의 수를 구하시오. 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem92 {

    public static void main(String[] args) {
        int n, limit;
        List<BagInform> bagInforms = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        limit = sc.nextInt();

        for(int i=0; i<n; i++) {
            bagInforms.add(new BagInform(sc.nextInt(), sc.nextInt()));
        }

        BagAlgorithm bagAlgorithm = new BagAlgorithm(bagInforms, limit);
        bagAlgorithm.mainLogic();
    }
}


class BagAlgorithm {

    private List<BagInform> bagInforms;
    private int limit;
    private int[] dp;

    public BagAlgorithm(List<BagInform> bagInforms, int limit) {
        this.bagInforms = bagInforms;
        this.limit = limit;
        this.dp = new int[limit+1];
    }

    void mainLogic() {
        System.out.println(dp());
    }

    int dp() {
        for(int i=0; i<bagInforms.size(); i++) {
            for(int j=0; j<=limit; j++) {
                if(j>=bagInforms.get(i).weight) {
                    dp[j] = Math.max(dp[j], dp[j - bagInforms.get(i).weight] + bagInforms.get(i).value);
                }
            }
        }

        return dp[limit];
    }
}

class BagInform {
    int weight;
    int value;
    public BagInform(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
