package inflearn;

/*
입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방 법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem34 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        SequenceSumPrinter printer = new SequenceSumPrinter(n);
        printer.betterMainLogic();
    }
}

class SequenceSumPrinter {

    private int n;

    public SequenceSumPrinter(int n) {
        this.n = n;
    }

    void mainLogic() {
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i=1; i<=n/2; i++) {
            int sum = i;
            list.clear();
            list.add(i);
            for(int j=i+1; j<=n; j++) {
                sum += j;
                list.add(j);
                if(sum == n) {
                    print(list);
                    count++;
                    break;
                }
                else if(sum > n) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    void betterMainLogic() {
        int i = n-1,  j = n-2;
        while(i >= 0 && j >= 0) {
            int sum = areaSum(i, j);
            if(sum > n) {
                i = i - 1;
                j = i - 1;
            }
            else if(sum == n) {
                print(i ,j);
                i = i - 1;
                j = i - 1;
            }
            else {
                j--;
            }
        }
    }

    void bestMainLogic() {
        // 1 + 2 -> (n - 3(숫자의 합)) % 2(숫자의 갯수) == 0 이면 몫을 각각 숫자들에게 분배하면 연속된 값들의 합 == n 을 만족하는 리스트들을 알 수 있다.)
        // 1 + 2 + 3 = 3  (n=15일 때, 15 - 6 = 9다. 9 % 3 == 0 이므로, 9/3 =3이니까, 1,2,3에게 3씩을 분배하면 4,5,6이 나온다. 그러므로 4 + 5 + 6 = 15인 것을 알 수 있다.)
    }

    int areaSum(int right, int left) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += i;
        }

        return sum;
    }

    void print(int right, int left) {
        for(int i = left; i <= right-1; i++){
            System.out.print(i + " + ");
        }

        System.out.println(right + " = " + n);
    }

    void print(List<Integer> list) {
        for(int i=0; i<list.size()-1; i++) {
            System.out.print(list.get(i) + " + ");
        }

        System.out.println(list.get(list.size()-1) + " = " + n);
    }
}
