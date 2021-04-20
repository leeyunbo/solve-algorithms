package inflearn;

import java.util.Arrays;
import java.util.Scanner;

/*
임의의 N개의 숫자가 입력으로 주어집니다. 
N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
 */

public class Problem35 {

    public static void main(String[] args) {
        int N, M;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }

        BinarySearchProgram program = new BinarySearchProgram(numbers, M);
        System.out.println(program.search(0, numbers.length-1) + 1);
    }
}

class BinarySearchProgram {

    private int[] numbers;
    private int M;

    public BinarySearchProgram(int[] numbers, int M) {
        this.numbers = numbers;
        this.M = M;
        initialized();
    }

    void initialized() {
        Arrays.sort(numbers);
    }

    int search(int left, int right) {
        if(left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        if(numbers[middle] == M) return middle;
        else if(numbers[middle] < M) return search(middle+1, right);
        else return search(left, middle-1);
    }
}
