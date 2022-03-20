package junior.inflearn;

/**
 * 자연수 N이 주어지면 아래와 같이 출력하는 프로그램을 작성하세요. 재귀함수를 이용해서 출
 * 력해야 합니다.
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=20)이 주어집니다.
 * ▣ 출력설명
 * 첫 번째 줄에 재귀함수를 이용해서 출력하세요.
 */

import java.util.Scanner;

public class Problem51 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        RecursionFunction function = new RecursionFunction(n);

        function.recursion(n);
    }
}

class RecursionFunction {

    private int n;

    public RecursionFunction(int n) {
        this.n = n;
    }

    void recursion(int temp) {
        if(temp == 0) return;
        recursion(temp-1);
        System.out.println(temp);
    }

}
