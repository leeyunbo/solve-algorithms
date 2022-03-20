package junior.inflearn;

/*
임의의 N에 대하여 N!은 1부터 N까지의 곱을 의미한다. 이는 N이 커짐에 따라 급격하게 커진다.
이러한 큰 수를 표현하는 방법으로 소수들의 곱으로 표현하는 방법이 있다. 먼저 소수는 2, 3, 5, 7, 11, 13... 순으로 증가함을 알아야 한다.
예를 들면 825는 (0 1 2 0 1)로 표현이 가능한데, 이는 2는 없고 3은 1번, 5는 2번, 7은 없고, 11은 1번의 곱이라는 의미이다.
101보다 작은 임의의 N에 대하여 N 팩토리얼을 이와 같은 표기법으로 변환하는 프로그램을 작성해 보자. 출력은 아래 예제와 같이 하도록 한다.
 */

import java.util.Scanner;

public class Problem26 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        FactorialPrinter printer = new FactorialPrinter(n);
        printer.mainLogic();
    }
}


class FactorialPrinter {

    private int n;
    private boolean[] isPrimeNumber;
    private int[] counts;

    public FactorialPrinter(int _n) {
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

    void print() {
        System.out.print(n +"! = ");
        for(int i=0; i<counts.length; i++) {
            if(isPrimeNumber[i] && counts[i] > 0) {
                System.out.print(counts[i] + " ");
            }
        }
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

        print();
    }
}
