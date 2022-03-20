package junior.inflearn;

/*
병합정렬 응용
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램
을 작성하세요.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem32 {

    public static void main(String[] args) {
        int n1, n2;
        int[] numbers1, numbers2;
        Scanner sc = new Scanner(System.in);

        n1 = sc.nextInt();
        numbers1 = new int[n1];
        for(int i=0; i<n1; i++) {
            numbers1[i] = sc.nextInt();
        }

        n2 = sc.nextInt();
        numbers2 = new int[n2];
        for(int i=0; i<n2; i++) {
            numbers2[i] = sc.nextInt();
        }

        MergeArray mergeArray = new MergeArray(numbers1, numbers2);
        mergeArray.merge();
    }
}

class MergeArray {

    private int[] numbers1;
    private int[] numbers2;

    public MergeArray(int _numbers1[], int _numbers2[]) {
        numbers1 = _numbers1;
        numbers2 = _numbers2;
    }

    void merge() {
        List<Integer> mergeArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < numbers1.length && j < numbers2.length) {
            if(numbers1[i] < numbers2[j]) {
                mergeArray.add(numbers1[i++]);
            }
            else {
                mergeArray.add(numbers2[j++]);
            }
        }

        while(i < numbers1.length) {
            mergeArray.add(numbers1[i++]);
        }

        while(j < numbers2.length) {
            mergeArray.add(numbers2[j++]);
        }

        print(mergeArray);
    }

    void print(List<Integer> mergeArray) {
        for(int temp : mergeArray) {
            System.out.print(temp + " ");
        }
    }
}



