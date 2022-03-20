package junior.inflearn;

import java.util.Scanner;

/*
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
을 작성하세요.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
▣ 출력설명
첫 번째 줄부터 각각의 부분집합을 출력합니다. 부분집합을 출력하는 순서는 출력예제에서 출 력한 순서와 같게 합니다. 단 공집합은 출력하지 않습니다.

 */

public class Problem53 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Subset subset = new Subset(n);

        subset.mainLogic(1);
    }
}

class Subset {

    private int n;
    private int[] ch;

    public Subset(int n) {
        this.n = n;
        ch = new int[n+1];
    }

    void mainLogic(int t) {
        if(t == n+1) {
            for(int i=1; i<=n; i++) {
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // 1. t를 포함시키거나
        ch[t] = 1;
        mainLogic(t+1);

        // 2. t를 포함시키지 않거나
        ch[t] = 0;
        mainLogic(t+1);
    }
}
