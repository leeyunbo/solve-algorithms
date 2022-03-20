package junior.inflearn;

/*
현수는 블록놀이를 좋아합니다.
현수에게 정면에서 본 단면과 오른쪽 측면에서 본 단면을 주 고 최대 블록개수를 사용하여 정면과 오른쪽 측면에서 본 모습으로 블록을 쌓으라 했습니다.
현수가 블록을 쌓는데 사용해야 할 최대 개수를 출력하는 프로그램을 작성하세요.

▣ 입력설명
첫 줄에 블록의 크기 N(3<=N<=10)이 주어집니다. 블록이 크기는 정사각형 N*N입니다. 두 번째 줄에 N개의 정면에서의 높이 정보가 왼쪽 정보부터 주어집니다.
세 번째 줄에 N개의 오른쪽 측면 높이 정보가 앞쪽부터 주어집니다.
블록의 높이는 10 미만입니다.
▣ 출력설명
첫 줄에 블록의 최대 개수를 출력합니다.
 */

import java.util.Scanner;

public class Problem43 {

    public static void main(String[] args) {
        int[] front, right;
        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        front = new int[n];
        right = new int[n];

        for(int i=0; i<n; i++) {
            front[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            right[i] = scanner.nextInt();
        }


        MaximumBlockCounter maximumBlockCounter = new MaximumBlockCounter(front, right);
        maximumBlockCounter.mainLogic();
    }
}

class MaximumBlockCounter {

    private int[] front;
    private int[] right;

    public MaximumBlockCounter(int[] front, int[] right) {
        this.front = front;
        this.right = right;
    }

    void mainLogic() {
        int sum = 0;

        for(int i=0; i<right.length; i++) {
            for(int j=0; j<front.length; j++) {
                sum += Math.min(right[i], front[j]);
            }
        }

        System.out.println(sum);
    }
}
