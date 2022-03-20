package junior.inflearn;

/**
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아 지의 위치가 직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성 하세요.
 * ▣ 입력설명
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000 까지이다.
 * ▣ 출력설명
 * 점프의 최소횟수를 구한다.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem63 {

    public static void main(String[] args) {
        int s,e;

        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        e = sc.nextInt();

        CowSearch cowSearch = new CowSearch(s, e);
        System.out.println(cowSearch.BFS());
    }
}

class CowSearch {

    private int s;
    private int e;
    private boolean[] isCheck;
    private int[] distance;
    private int[] move = {-1,1,5};

    public CowSearch(int s, int e) {
        this.s = s;
        this.e = e;
        distance = new int[10001];
        isCheck = new boolean[10001];
    }

    int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i=0; i<move.length; i++) {
                int next = temp + move[i];
                if(next == e) return distance[temp] + 1;

                if(isCheck[next]) continue;
                queue.add(next);
                distance[next] = distance[temp] + 1;
                isCheck[next] = true;
            }
        }

        return -1;
    }
}
