package junior.inflearn;

import java.util.Arrays;
import java.util.Scanner;
/*
N개의 마구간이 1차원 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가 지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대 값을 출력하는 프로그램을 작성하세요.
▣ 입력설명
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다. 둘째 줄부터 N개의 줄에 걸쳐 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 한 줄에 하나씩 주어집니다.
▣ 출력설명
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

*로직*
이것도 Problem36.java or Problem39.java와 동일한 문제이다.
결정 알고리즘을 활용한다.(정답을 결정해놓고 정답이 맞는지 체크해가며 최적의 값을 찾는 알고리즘)

1. 어떤 길이 a를 정했을 때, c마리의 말을 놓을 때 그 c마리 사이의 거리가 모두 a를 넘는다면 a는 최소거리가 될 수 있으며 a보다 큰 숫자도 가능할 수도 있다. left = mid + 1
2. 어떤 길이 a를 정했을 떄, c마리의 말을 놓을 때 그 c마리 사이의 거리가 하나라도 a를 넘지 못한다면 a는 최소거리 될 수 없으며 a보다 큰 숫자도 모두 불가능하다. right = mid - 1


위의 두 조건때문에, 결정 알고리즘을 활용할 때 이진 탐색을 적할 수 있다.

1. 최댓값을 구한다 (모든 값을 더한 값 -> M이 1이여도 담을 수 있다.)
2. 최솟값을 구한다 (이거 당연히 가장 작은 값)
3. 최댓값과 최솟값을 이용하여 이진탐색을 시작한다.
 3-1. 저 위의 조건을 반복한다.
 3-2. 최대한 범위가 좁혀 졌을 떄 더이상 좁혀지지 않는다면 그 값이 바로 정답이다. (최적의 해이니까)
 */


public class Problem37 {

    public static void main(String[] args) {
        int[] stalls;
        int n, c;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        stalls = new int[n];
        for(int i=0; i<n; i++) {
            stalls[i] = sc.nextInt();
        }

        DecisionStall decisionStall = new DecisionStall(stalls, c);
        int result = decisionStall.mainLogic();
        System.out.println(result);
    }
}

class DecisionStall {
    private int[] stalls;
    private int c;

    public DecisionStall(int[] stalls, int c) {
        this.stalls = stalls;
        this.c = c;
        initialized();
    }

    void initialized() {
        Arrays.sort(stalls);
    }


    int mainLogic() {
        int left = 1, result = 0;
        int right = stalls[stalls.length-1];

        if(c == 2) return right - left;

        while(left <= right) {
            int dis = (left + right) / 2;
            if(check(dis) >= c) {
                result = dis;
                left = dis + 1;
            }
            else {
                right = dis - 1;
            }
        }

        return result;
    }

    /**
     * 주요 로직
     * @param dis
     * @return
     */
    int check(int dis) {
        int horse = 1;
        // 1. 가장 첫번째 위치에 말을 놓아야 최대한의 거리를 이용할 수 있다 -> 조건을 충족할 확률이 가장 높음(조건만 충족하면 되니까)
        int pos = 0;

        // 2. 범위를 넓혀가면서 pos 위치와 거리를 계산한다.
        for(int i=1; i<stalls.length; i++) {
            // 2-1. 만약 계산한 거리가 최소 넘어야할 거리인 dis를 넘는다면 다음 말을 놓도록 한다.
            if(stalls[i] - stalls[pos] >= dis) {
                horse++;
                pos = i;
            }
        }

        return horse;
    }
}
