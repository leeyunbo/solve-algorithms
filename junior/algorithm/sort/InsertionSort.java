package junior.algorithm.sort;

/*
삽입 정렬
 */

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        int n;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        InsertionSortProgram program = new InsertionSortProgram(numbers);
        program.sort();
        program.print();
    }
}

class InsertionSortProgram {

    private int[] numbers;

    public InsertionSortProgram(int[] _numbers) {
        numbers = _numbers;
    }

    void sort() {
        for(int i=1; i<numbers.length; i++) {
            int temp = numbers[i];
            int j;
            for(j = i-1; j>=0 && numbers[j] > temp; j--) {
                numbers[j+1] = numbers[j];
            }
            numbers[j+1] = temp;
        }
    }

    void print() {
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
