package inflearn2;

/**
 * n과 r이 주어질 때
 * n개의 자연수에서 r개의 자연수를 뽑는 모든 경우의 수를 출력하세요.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Problem75 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,r;
        int[] numbers;

        n = sc.nextInt();
        r = sc.nextInt();
        numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        Permutation permutation = new Permutation(numbers, r);
        permutation.mainLogic();
    }
}


class Permutation {

    private boolean[] isCheck = new boolean[16];
    private LinkedList<Integer> list = new LinkedList<>();
    private int[] numbers;
    private int r;

    public Permutation(int[] numbers, int r) {
        this.numbers = numbers;
        this.r = r;
    }

    protected int cntPermutation(int select) {
        if(select == r) {
            for(int number : list) {
                System.out.print(number + " ");
            }
            System.out.println();
            return 1;
        }

        int cnt = 0 ;
        for(int i=0; i<numbers.length; i++) {
            if(isCheck[numbers[i]] == false) {
                isCheck[numbers[i]] = true;
                list.add(numbers[i]);
                cnt += cntPermutation(select+1);
                list.pollLast();
                isCheck[numbers[i]] = false;
            }
        }

        return cnt;
    }

    public void mainLogic() {
        System.out.println(cntPermutation(0));
    }
}
