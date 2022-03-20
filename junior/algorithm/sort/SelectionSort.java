package junior.algorithm.sort;

import java.util.Scanner;

/*
Selection Sort
같은 숫자가 없는 가정하에, 3번째 for문을 돌 때 3번째로 작은 숫자가 출력되겠군
 */

public class SelectionSort {

    public static void main(String[] args) {
        int n;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for(int i=0; i<n;i ++) {
            numbers[i] = sc.nextInt();
        }

        SelectionSortProgram program = new SelectionSortProgram(numbers);
        program.sort();
        program.print();
    }
}

class SelectionSortProgram {

    private int[] numbers;

    public SelectionSortProgram(int[] _numbers) {
        numbers = _numbers;
    }

    void sort() {
        int min;
        for(int i=0; i<numbers.length-1; i++) {
            min = i;
            for(int j=i; j<numbers.length; j++) {
                if(numbers[j] < numbers[min]) min = j;
            }
            SWAP(i,min);
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
