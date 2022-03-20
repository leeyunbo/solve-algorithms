package junior.inflearn;

/*
KSEA 장거리 달리기 대회가 진행되어 모든 선수가 반환점을 넘었다.
각 선수의 입장에서 자 기보다 앞에 달리고 있는 선수들 중 평소 실력이 자기보다 좋은 선수를 남은 거리 동안 앞지 르는 것은 불가능하다.
반대로, 평소 실력이 자기보다 좋지 않은 선수가 앞에 달리고 있으면 남은 거리 동안 앞지르는 것이 가능하다.
이러한 가정 하에서 각 선수는 자신이 앞으로 얻을 수 있는 최선의 등수를 알 수 있다.
각 선수의 평소 실력은 정수로 주어지는데 더 큰 값이 더 좋은 실력을 의미한다.
현재 달리고 있는 선수를 앞에서 부터 표시했을 때 평소 실력이 각각 2, 8, 10, 7, 1, 9, 4, 15라고 하면 각 선수가 얻을 수 있는 최선의 등수는 (같은 순서로) 각각 1, 1, 1, 3, 5, 2, 5, 1이 된다.
예를 들어, 4번째로 달리고 있는 평소 실력이 7인 선수는 그 앞에서 달리고 있는 선수들 중 평 소 실력이 2인 선수만 앞지르는 것이 가능하고 평소실력이 8과 10인 선수들은 앞지르는 것이 불가능하므로, 최선의 등수는 3등이 된다.
선수들의 평소 실력을 현재 달리고 있는 순서대로 입력 받아서 각 선수의 최선의 등수를 계산 하는 프로그램을 작성하시오.
▣ 입력설명
첫째 줄에는 선수의 수를 의미하는 정수 N이 주어진다. N은 3 이상 10,000 이하이다. 다음 줄에는 N개의 정수가 주어진다.
이 값들은 각 선수들의 평소 실력을 앞에서 달리고 있는 선수 부터 제시한 것이다. 각 정수는 1 이상 100,000 이하이다.
참가한 선수의 평소실력은 같을 수 있습니다. 그리고 실력이 같다면 앞에 달리는 선수를 앞지를 수 없습니다.
▣ 출력설명
각 선수의 최선의 등수를 나타내는 정수 N개를 입력에 주어진 선수 순서와 동일한 순서로 한 줄에 출력한다. 모든 정수들 사이에는 하나의 공백을 둔다.

 */

import java.util.Scanner;

public class Problem25 {

    public static void main(String[] args) {
        int N;
        int[] players;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        players = new int[N+1];

        for(int i=1; i< players.length; i++) {
            players[i] = sc.nextInt();
        }

        MaratonRankCalculator calculator = new MaratonRankCalculator(players);
        calculator.calculatePlayerRank();
    }
}


class MaratonRankCalculator{

    int[] players;

    public MaratonRankCalculator(int[] _players) {
        players = _players;
    }

    public void calculatePlayerRank() {
        int tempPlayer, slowCnt;
        int[] ranks = new int[players.length];
        ranks[1] = 1;

        for(int i=2; i<players.length; i++) {
            tempPlayer = players[i];
            slowCnt = 0;
            for(int j=i-1; j>=1; j--) {
                if(tempPlayer > players[j]) {
                    slowCnt++;
                }
            }

            ranks[i] = i - slowCnt;
        }

        for(int i=1; i<ranks.length; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}
