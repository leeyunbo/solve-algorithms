package inflearn;

import java.util.Scanner;
import java.util.Stack;

/**
 * 10진수 N이 입력되면 K진수로 변환하여 출력하는 프로그램을 작성하세요.
 * 스택 자료구조를 사용하시기 바랍니다.
 * ▣ 입력설명
 * 첫 번째 줄에 10진수 N(10<=N<=1,000)과 K(2, 5, 8, 16)가 주어진다.
 * ▣ 출력설명 K진수를 출력한다.
 */

public class Problem47 {

    public static void main(String[] args) {
        int n,k;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        BinaryConverter binaryConverter = new BinaryConverter(n, k);
        System.out.println(binaryConverter.convert());
    }
}


// 16진수 -> 10 A 11 B 12 C 13 D 14 E 15 F
class BinaryConverter {

    private int n,k;

    public BinaryConverter(int n, int k) {
        this.n = n;
        this.k = k;
    }

    String convert() {
        Stack<Integer> stack = new Stack();

        int temp = n;
        while(temp >= k) {
            stack.push(temp%k);
            temp = temp/k;
        }

        stack.push(temp);

        return make(stack);
    }

    String make(Stack<Integer> stack) {
        String answer = "";
        String numbers = "0123456789ABCDEF";


        while(!stack.isEmpty()) {
            char data = numbers.charAt(stack.pop());
            answer += data;
        }

        return answer;
    }


}
