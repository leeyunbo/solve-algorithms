package inflearn;

/*
N개의 원소로 구성된 자연수 집합이 주어지면, 집합의 원소와 ‘+’, ‘-’ 연산을 사용하여 특정 수인 M을 만드는 경우가 몇 가지 있는지 출력하는 프로그램을 작성하세요. 각 원소는 연산에 한 번만 사용합니다.
예를 들어 {2, 4, 6, 8}이 입력되고, M=12이면
2+4+6=12
4+8=12
6+8-2=12
2-4+6+8=12
로 총 4가지의 경우가 있습니다. 만들어지는 경우가 존재하지 않으면 -1를 출력한다.
▣ 입력설명
첫 번째 줄에 자연수 N(1<=N<=10)와 M(1<=M<=100) 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
▣ 출력설명
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 */

import java.util.Scanner;

public class Problem55 {

    public static void main(String[] args) {
        int n, m;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        CreateNumber createNumber = new CreateNumber(n , m, arr);
        createNumber.D(0, 0);
        if(createNumber.cnt == 0) System.out.println(-1);
        else System.out.println(createNumber.cnt);
    }
}

class CreateNumber {

    int cnt = 0;
    private int n;
    private int m;
    private int[] arr;

    public CreateNumber(int n, int m, int[] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr;
    }

    void D(int sum, int temp) {
        if(temp == n) {
            if(sum == m) cnt++;
            return;
        }

      // 1. 더하는 경우 
        D(sum + arr[temp], temp + 1);
      // 2. 빼는 경우 
        D(sum - arr[temp], temp + 1);
      // 3. 더하지도 않고 빼지도 않는 경우 
        D(sum, temp + 1);
    }
}
