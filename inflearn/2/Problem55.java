package inflearn;

/*
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않으며 그 크기는 1,000,000 이하입니다.
▣ 출력설명
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 */

import java.util.Scanner;

public class Problem54 {

    public static void main(String[] args) {
        int[] arr;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        SumSubset subset = new SumSubset(n, arr);
        subset.D(1, 0, 0);

        if(subset.isYes == false) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }
}

class SumSubset {

    private int n;
    private int[] arr;
    boolean isYes = false;

    public SumSubset(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
    }

    void D(int t, int sum1, int sum2) {
        if(isYes) return;

        if(t == n+1) {
            if(sum1 == sum2) isYes = true;
            return;
        }

        //1. temp가 ch1에 포함될 경우
        D(t+1, sum1 + arr[t], sum2);

        //2. temp가 ch2에 포함될 경우
        D(t+1, sum1, sum2 + arr[t]);
    }
}
