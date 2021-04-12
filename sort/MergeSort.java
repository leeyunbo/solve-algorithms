package sort;

/*
MergeSort
나누는 과정을 먼저함으로써 나뉘어진 배열을 합칠 때 두 배열이 무조건 정렬되어있다는 것을 알 수 있음 
-> 두 배열을 합치게 되면 무조건 정렬된 배열이 나올 수 밖에 없음 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {

        int n;
        int[] numbers;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        MergeSortProgram program = new MergeSortProgram(numbers);
        program.divide(0, numbers.length-1);
        program.print();

    }
}

class MergeSortProgram {

    private int[] numbers;

    public MergeSortProgram(int[] _numbers) {
        numbers = _numbers;
    }

    void sort(int left, int right, int mid) {
        List<Integer> list = new ArrayList<>();

        int k = 0;
        int l = left;
        int r = mid+1;

        while(l <= mid && r <= right) {
            if(numbers[l] < numbers[r]) {
                list.add(numbers[l++]);
            }
            else {
                list.add(numbers[r++]);
            }
        }

        while(l <= mid) {
            list.add(numbers[l++]);
        }

        while(r <= right) {
            list.add(numbers[r++]);
        }

        for(int i=left; i<=right; i++) {
            numbers[i] = list.get(k++);
        }
    }

    void divide(int left, int right) {
        int mid = (left+right)/2;

        if(left < right) {
            divide(left, mid);
            divide(mid + 1, right);
            sort(left, right, mid);
        }
    }

    void print() {
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
