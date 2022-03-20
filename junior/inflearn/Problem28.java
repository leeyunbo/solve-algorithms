package junior.inflearn;

/*
자연수 N이 입력되면 1부터 N까지의 자연수를 종이에 적을 때 각 숫자 중 3의 개수가 몇 개 있는지 구하려고 합니다.
예를 들어 1부터 15까지는 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5으로 3의 개수는 2개입니다.
자연수 N이 입력되면 1부터 N까지 숫자를 적을 때, 3의 개수가 몇 개인지 구하여 출력하는 프로그램을 작성하세요.

*아이디어*
얘는 최대 데이터가 10만이기 때문에, 단순히 for문으로 해결할 수 있다.
String 변수에 숫자를 넣고 각 자릿수를 카운트 해주면 된다.
 */

import java.util.Scanner;

public class Problem28 {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();


        if(n < 3) {
            System.out.println(0);
            return;
        }
        FactorialThreeCounter counter = new FactorialThreeCounter(n);
        counter.mainLogic();
    }
}

class FactorialThreeCounter {

    private int n;
    private int count = 0;


    public FactorialThreeCounter(int _n) {
        n = _n;
    }

    void mainLogic() {
        for(int i=1; i<=n; i++) {
            String str = String.valueOf(i);
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) - 48 == 3) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }


}
