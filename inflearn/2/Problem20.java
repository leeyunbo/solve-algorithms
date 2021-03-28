package inflearn;

/*
A와 B가 늘어놓은 카드의 숫자가 순서대로 주어질 때, 게임의 승자가 A인지 B인지, 또는 비겼는지 결정하는 프로그램을 작성하시오.

첫 번째 줄에는 게임이 끝난 후, A와 B가 받은 총 승점을 순서대로 빈칸을 사이에 두고 출력 한다.
두 번째 줄에는 이긴 사람이 A인지 B인지 결정해서, 이긴 사람을 문자 A 또는 B로 출력 한다.
만약 비기는 경우에는 문자 D를 출력한다.
 */

import java.util.Scanner;

public class Problem20 {

    public static void main(String[] args) {
        int[] A;
        int[] B;

        Scanner sc = new Scanner(System.in);


        String resultA = sc.nextLine();
        String resultB = sc.nextLine();

        String[] strA = resultA.split(" ");
        String[] strB = resultB.split(" ");

        A = new int[strA.length];
        B = new int[strA.length];

        for(int i=0; i<strA.length; i++) {
            A[i] = Integer.parseInt(strA[i]);
            B[i] = Integer.parseInt(strB[i]);
        }

        GameWinnerPrinter printer = new GameWinnerPrinter(A, B);
        printer.printGameWinner();
    }
}


class GameWinnerPrinter {

    int[] A, B;

    public GameWinnerPrinter(int[] _A, int[] _B) {
        A = _A;
        B = _B;
    }

    void printGameWinner() {
        int aScore = 0, bScore = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i] > B[i]) {
                aScore += 3;
            }
            else if(A[i] == B[i]) {
                aScore += 1;
                bScore += 1;
            }
            else {
                bScore += 3;
            }
        }

        System.out.println(aScore + " " + bScore);
        if(aScore > bScore) {
            System.out.println("A");
        }
        else if(bScore > aScore) {
            System.out.println("B");
        }
        else {
            System.out.println("D");
        }


    }
}



