package junior.inflearn;

/*
자연수 N이 입력되면 N! 값에서 일의 자리부터 연속적으로 ‘0’이 몇 개 있는지 구하는 프로그 램을 작성하세요.
만약 5! = 5×4×3×2×1 = 120으로 일의자리부터 연속적된 ‘0’의 개수는 1입니다.
만약 12! = 479001600으로 일의자리부터 연속적된 ‘0’의 개수는 2입니다.

*아이디어*
십진수 같은 경우는 a X 10^n 으로 이루어져있음, 즉 10의 갯수가 연속된 0의 갯수라고 할 수 있다!
인수 분해를 통해 나눈 후 2와 5의 갯수 중 최솟값을 출력하면 된다 (2 X 5 = 10)

 */

import java.util.Scanner;

public class Problem27 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if(n<=4) {
            System.out.println(0);
            return;
        }

        FactorialZeroCounter counter = new FactorialZeroCounter(n);
        counter.mainLogic();
    }
}

class FactorialZeroCounter {

    private int n;
    private boolean[] isPrimeNumber;
    private int[] counts;

    public FactorialZeroCounter(int _n) {
        n = _n;
        isPrimeNumber = new boolean[n+1];
        counts = new int[n+1];
    }

    void initialized() {
        for(int i=2; i<isPrimeNumber.length; i++) {
            if(isPrime(i)) {
                isPrimeNumber[i] = true;
            }
        }
    }

    boolean isPrime(int n) {
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    void mainLogic() {
        initialized();

        for(int i=1; i<=n; i++) {
            if(isPrimeNumber[i]) {
                counts[i]++;
            }
            else {
                subLogic(i);
            }
        }

        System.out.println(Math.min(counts[2], counts[5]));
    }

    void subLogic(int n) {
        while(n != 1) {
            for(int i=2; i<=n; i++) {
                if((n % i) == 0) {
                    n = n / i;
                    counts[i]++;
                    break;
                }
            }
        }
    }

}
