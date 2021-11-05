package algorithm;

import java.util.Arrays;

public class QuickSort {
    private static final int[] numbers = {6,5,4,3,2,1,0,1,2,3,45,634,6346,345,2344523,4523,523,523,623,54,4,3,2,3,4,3,42,3,45235,235,235623,623,623,423,4,35,235,334,1};
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.divide(0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }

    private void divide(int left, int right) {
        if(left < right) {
            int pivot = sort(left, right);
            divide(left, pivot - 1);
            divide(pivot + 1, right);
        }
    }

    private int sort(int left, int right) {
        int key = numbers[right];
        int l = left, r = right;

        while(l < r) {
            while(l < r && key >= numbers[l]) {
                l++;
            }
            while (l < r && key <= numbers[r]) {
                r--;
            }
            if(l < r) SWAP(l,r);
        }

        numbers[right] = numbers[l];
        numbers[l] = key;

        return l;
    }

    private void SWAP(int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
