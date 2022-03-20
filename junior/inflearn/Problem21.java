package junior.inflearn;

/*
매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.
예를 들어, 다음과 같이 10일 간의 온도가 주어졌을 때, 3 -2 -4 -9 0 3 7 13 8 -3 모든 연속적인 이틀간의 온도의 합은 다음과 같다.
이때, 온도의 합이 가장 큰 값은 21이다.
매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class Problem21 {

    public static void main(String[] args) {
        int[] temperatures;
        int N, K;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        temperatures = new int[N];
        for(int i=0; i<N; i++) {
            temperatures[i] = sc.nextInt();
        }

        TemperatureChecker checker = new TemperatureChecker(temperatures, K);
        int result = checker.checkTemperature();
        System.out.println(result);
    }
}

class TemperatureChecker {

    int[] temperatures;
    int K;

    public TemperatureChecker(int[] _temperatures, int _K) {
        temperatures = _temperatures;
        K = _K;
    }


    int checkTemperature() {
        int max = -654321, total = 0;

        for(int i=0; i<K; i++) {
            total += temperatures[i];
        }
        max = Math.max(total, max);


        for(int last=K; last<temperatures.length; last++) {
            total = total + temperatures[last];
            total = total - temperatures[last-K];

            max = Math.max(total, max);
        }

        return max;
    }
}
