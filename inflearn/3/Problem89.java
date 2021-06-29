package dp;

/**
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래 에서 위로 쌓으면서 만들어 간다.
 * 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
 * (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 * (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 * (조건3) 벽돌들의 높이는 같을 수도 있다.
 * (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 * (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 */

import java.util.*;

public class Problem89 {

    public static void main(String[] args) {
        int n;
        List<Rock> rocks = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++) {
            rocks.add(new Rock(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }


        HighestTower highestTower = new HighestTower(rocks);
        highestTower.mainLogic();

    }
}

class HighestTower {

    private List<Rock> rocks;
    private int[] dp;

    public HighestTower(List<Rock> rocks) {
        this.rocks = rocks;
        this.dp = new int[rocks.size()];
    }

    void mainLogic() {
        Collections.sort(rocks);

        int i = 0;
        for(Rock rock : rocks) {
            dp[i++] = rock.height;
        }

        System.out.println(dp());
    }

    int dp() {
        for(int i=1; i<rocks.size(); i++) {
            for(int j=i-1; j>=0; j--) {
                if(rocks.get(j).weight > rocks.get(i).weight) {
                    dp[i] = Math.max(dp[i], dp[j] + rocks.get(i).height);
                }
            }
        }

        Arrays.sort(dp);

        return dp[rocks.size()-1];
    }
}

class Rock implements Comparable<Rock>{
    int bottom;
    int height;
    int weight;

    public Rock(int bottom, int height, int weight) {
        this.bottom = bottom;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Rock o) {
        if(this.bottom > o.bottom) {
            return -1;
        }
        else if(this.bottom < o.bottom) {
            return 1;
        }
        else return 0;
    }
}
