/*
어떤 수를 소인수분해 했을 때 그 소인수가 2 또는 3 또는 5로만 이루어진 수를 Ugly Number라고 부릅니다. Ugly Number를 차례대로 적어보면
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, .......입니다. 숫자 1은 Ugly Number의 첫 번째 수로 합 니다. 
 자연수 N이 주어지면 Ugly Number를 차례로 적을 때 N번째 Ugly Number를 구하는 프로그램을 작성하세요.
▣ 입력설명
첫 줄에 자연수 N(3<=N<=1500)이 주어집니다.
▣ 출력설명 첫 줄에 N번째
▣ 입력예제 1 10
▣ 출력예제 1 12
▣ 입력예제 2 1500
▣ 출력예제 2 859963392
Ugly Number를 출력하세요.
*/
  
package inflearn;

import java.util.Scanner;

public class Problem46 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        UglyNumbers uglyNumbers = new UglyNumbers(n);
        uglyNumbers.mainLogic();
    }
}

class UglyNumbers {

    private int n;

    public UglyNumbers(int n) {
        this.n = n;
    }

    void mainLogic() {
        int[] a = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;

        a[0] = 1;
        for(int i=1; i<n; i++) {
            int r2 = a[p2] * 2;
            int r3 = a[p3] * 3;
            int r5 = a[p5] * 5;
            int min = Math.min(Math.min(r2, r3),r5);
            a[i] = min;

            if(min == r2) p2++;
            if(min == r3) p3++;
            if(min == r5) p5++;
        }

        System.out.println(a[n-1]);
    }
}
