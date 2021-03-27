package inflearn;

/*
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램 을 작성하세요.
 */

import java.util.LinkedList;
import java.util.Scanner;

// 2 -> 1 , 3 -> 2, 1 -> 3
public class Problem19 {

    public static void main(String[] args) {
        int N;
        int[] A, B;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        A = new int[N];
        B = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            B[i] = sc.nextInt();
        }

        GameResultPrinter printer = new GameResultPrinter(A, B);
        printer.printGameResult();
    }
}



class GameResultPrinter {

    private int[] winnerGraph = new int[4];
    private int[] A;
    private int[] B;

    public GameResultPrinter(int[] _A, int[] _B) {
        A = _A;
        B = _B;
        winnerGraph[1] = 3;
        winnerGraph[2] = 1;
        winnerGraph[3] = 2;
    }

    void printGameResult() {
        for(int i=0; i<A.length; i++) {
            if(winnerGraph[A[i]] == B[i]) {
                System.out.println("A");
            }
            else if(A[i] == B[i]) {
                System.out.println("D");
            }
            else {
                System.out.println("B");
            }
        }
    }


}
