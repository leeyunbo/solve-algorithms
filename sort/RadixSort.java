package algorithm;

import java.util.*;

public class RadixSort {

    private static final int[] numbers = {10,20,40,48,101,203,404,695,3,8,9,10,24};
    private static final ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();

        for(int i=0; i<10; i++) {
            buckets.add(new LinkedList<>());
        }

        int digit = radixSort.getMaximumDigit();
        for(int i=1; i<=digit; i++) {
            for (int number : numbers) {
                int digitValue = radixSort.getDigitValue(number, i);
                buckets.get(digitValue).offer(number);
            }

            int idx = 0;
            for (LinkedList<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    numbers[idx++] = bucket.poll();
                }
            }
        }

        System.out.println(Arrays.toString(numbers));

    }

    private int getMaximumDigit() {
        int max = 0;
        for (int number : numbers) {
            max = Math.max((int) Math.log10(number)+1, max);
        }
        return max;
    }

    private int getDigitValue(int number, int digit) {
        return (int) (number / Math.pow(10, digit-1)) % 10;
    }
}
