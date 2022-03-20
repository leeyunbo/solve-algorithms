package junior.algorithm.sort;

/*
버블 정렬
 */

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        BubbleSortProgram program = new BubbleSortProgram(numbers);
        program.sort();
        program.print();
    }
}


class BubbleSortProgram {

    private int[] numbers;

    public BubbleSortProgram(int[] _numbers) {
        numbers = _numbers;
    }

    public void sort() {
        // 맨 앞 원소는 결국 자동으로 위치가 지정된다. (n-1)
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=0; j<numbers.length-1-i; j++) {
                if(numbers[j] > numbers[j+1]) {
                    SWAP(j, j+1);
                }
            }
        }
    }

    void SWAP(int n1, int n2) {
        int temp = numbers[n1];
        numbers[n1] = numbers[n2];
        numbers[n2] = temp;
    }

    void print() {
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

}
