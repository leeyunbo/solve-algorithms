package junior.inflearn;

/*
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
제한시간은 1초입니다.

▣ 입력설명
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
▣ 출력설명
첫 줄에 소수의 개수를 출력합니다.
 */

import java.io.IOException;
import java.util.Scanner;

public class Problem14 {

    public static void main(String[] args) throws IOException {
        int n, cnt=0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        PrimeLogicModule module = new PrimeLogicModule();

        for(int i=1; i<=n; i++) {
            if(module.isPrime(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}

class PrimeLogicModule {

    boolean isPrime(int x) {

        if (x == 1) return false;

        // 1. 1~ N까지 모든 수를 나눴을 떄, 1이랑 본인으로만 나뉘어지는 경우 소수이다.
        for (int i = 2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
