package inflearn;

/*
두 집합 A, B가 주어지면 두 집합의 교집합을 출력하는 프로그램을 작성하세요.

▣ 입력설명
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 각 집합의 원소는 int형 변수의 크기를 넘지 않습니다.
▣ 출력설명
두 집합의 교집합을 오름차순 정렬하여 출력합니다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Problem33 {

    public static void main(String[] args) {
        int N, M;
        int[] numbers1, numbers2;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers1 = new int[N];
        for(int i=0; i<N; i++) {
            numbers1[i] = sc.nextInt();
        }

        M = sc.nextInt();
        numbers2 = new int[M];
        for(int i=0; i<M; i++) {
            numbers2[i] = sc.nextInt();
        }

        IntersectionPrinter printer = new IntersectionPrinter(numbers1, numbers2);
        printer.mainLogic();
    }
}

class IntersectionPrinter {

    private int[] numbers1, numbers2;

    public IntersectionPrinter(int[] numbers1, int[] numbers2) {
        this.numbers1 = numbers1;
        this.numbers2 = numbers2;
    }

    void mainLogic() {
        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        int i = 0, j = 0;
        while(i < numbers1.length && j < numbers2.length) {
            if(numbers1[i] == numbers2[j]) {
                System.out.print(numbers1[i] + " ");
                i++;
                j++;
            }
            else if(numbers1[i] < numbers2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
    }
}
