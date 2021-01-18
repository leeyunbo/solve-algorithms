package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/10816
 * 백준 숫자 카드2
 */

import java.io.*;
import java.util.Arrays;

public class NumberCard2 {

    static int[] numbers, aims;

    public static void main(String[] args) throws IOException {
        int n, m;
        String[] line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        line = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        m = Integer.parseInt(br.readLine());
        aims = new int[m];
        line = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            aims[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(numbers);
        for(int i=0; i<aims.length; i++) {
            bw.write(upperBound(0, numbers.length, aims[i]) - lowerBound(0, numbers.length, aims[i]) + " ");
        }

        bw.flush();
        bw.close();
    }

    static int lowerBound(int left, int right, int aim) {
        while(left < right) {
            int middle = (left+right)/2;
            if(numbers[middle] >= aim) right = middle - 1;
            else left = middle + 1;
        }

        return right;
    }

    static int upperBound(int left, int right, int aim) {
        while(left < right) {
            int middle = (left+right)/2;
            if(numbers[middle] <= aim) left = middle + 1;
            else right = middle - 1;
        }

        return right;
    }
}
