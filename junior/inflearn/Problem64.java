package junior.inflearn;

/**
 *
 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다. 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
 왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다. 그리고 1번 왕자부터 N 번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다. 그리고 1번 왕자부터 시 계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다. 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다. 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
 이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.

 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3 을 외쳐 제외된다. 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7 번 왕자에게 공주를 구하러갑니다.
 N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem64 {

    public static void main(String[] args) {
        int n,k;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        CircleGame circleGame = new CircleGame(n, k);
        System.out.println(circleGame.start());
    }
}

class CircleGame {

    private int n,k;

    public CircleGame(int n, int k) {
        this.n = n;
        this.k = k;
    }

    int start() {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            q1.add(i);
        }

        int cnt = 1;
        int flag = 1;
        while(true) {
            if((q1.isEmpty() && q2.size() == 1) || (q1.size() == 1 && q2.isEmpty())) {
                if(q1.size() > q2.size()) return q1.poll();
                else return q2.poll();
            }

            if (q1.isEmpty()) flag = 2;
            if (q2.isEmpty()) flag = 1;

            if(cnt == k) {
                if(flag == 1) {
                    q1.poll();
                }
                else if(flag == 2) {
                    q2.poll();
                }
                cnt = 1;
                continue;
            }
            else {
                if(flag == 1) {
                    q2.add(q1.poll());
                }
                else if(flag == 2) {
                    q1.add(q2.poll());
                }
            }

            cnt++;
        }
    }
}


