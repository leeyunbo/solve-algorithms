/*
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
해서 출력해야 합니다.
▣ 입력설명
첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
▣ 출력설명
첫 번째 줄에 이진수를 출력하세요.
*/

package inflearn;

import java.util.Scanner;

public class Problem52 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        RecursionBinaryConverter converter = new RecursionBinaryConverter();
        System.out.println(converter.convert(n));
    }
}

class RecursionBinaryConverter {

    String convert(int n) {
        String answer = "";
        int temp;

        if(n < 2) return answer + n;

        temp = n % 2;
        answer += convert(n/2);
        return answer + temp;
    }
}
