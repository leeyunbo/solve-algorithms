package junior.algorithm.sort;

/*
MergeSort
 */

public class MergeSort {

    public static void main(String[] args) {

        int n;
        int[] numbers = {10,9,7,6,5,4,3,2,5,4,32,2,1,1};

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

    void merge(int left, int right, int mid) {
        int[] buffer = new int[right-left+1];
        int bufferIdx = 0, l = left, r = mid+1;
        while(l <= mid && r <= right) {
            if(numbers[l] < numbers[r]) {
                buffer[bufferIdx++] = numbers[l++];
            }
            else {
                buffer[bufferIdx++] = numbers[r++];
            }
        }

        while(l <= mid) {
            buffer[bufferIdx++] = numbers[l++];
        }

        while(r <= right) {
            buffer[bufferIdx++] = numbers[r++];
        }

        for(int i=left; i<=right; i++) {
            numbers[i] = buffer[i-left];
        }
    }

    void divide(int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            divide(left, mid);
            divide(mid+1, right);
            merge(left, right, mid);
        }
    }

    void print() {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
