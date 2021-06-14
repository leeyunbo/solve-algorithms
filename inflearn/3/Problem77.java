package inflearn2;

/**
 * 길이가 n인 자연수로 이루어진 수열이 주어진다.
 * 수열의 각 항 사이에 끼워넣을 n-1개의 연산자가 주어진다.
 * 연산자가 끼워진 수식을 만들어 계산했을 때 최댓값과 최솟값을 구하시오.
 */

import java.util.*;

public class Problem77 {

    public static void main(String[] args) {
        int[] numbers;
        int[] op;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        op = new int[4];

        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++) {
            op[i] = sc.nextInt();
        }


        CreateMathExp createMathExp = new CreateMathExp(numbers, op, n);
        createMathExp.start();
    }
}


class CreateMathExp {

    private int n = 0;
    private int maxResult = 0;
    private int minResult = 654321;
    private LinkedList<Integer> list = new LinkedList<>();
    private int[] numbers;
    private int[] op;

    public CreateMathExp(int[] numbers, int[] op, int n) {
        this.numbers = numbers;
        this.op = op;
        this.n = n;
    }

    void start() {
        DFS(0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    void DFS(int select) {
        if(select == n-1) {
            int result = calc();
            minResult = Math.min(result, minResult);
            maxResult = Math.max(result, maxResult);
            return;
        }

        for(int i=0; i<4; i++) {
            if(op[i] > 0) {
                op[i]--;
                list.add(i);
                DFS(select+1);
                list.pollLast();
                op[i]++;
            }
        }
    }

    int calc() {
        int result = numbers[0];
        int idx = 0;

        for(int i=0; i<n-1; i++) {
            idx = list.pollFirst();
            switch (idx) {
                case 0 :
                    result = result + numbers[i+1];
                    break;
                case 1 :
                    result = result - numbers[i+1];
                    break;
                case 2 :
                    result = result * numbers[i+1];
                    break;
                case 3 :
                    result = result / numbers[i+1];
                    break;
            }
        }

        return result;
    }
}
