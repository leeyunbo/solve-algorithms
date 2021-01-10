package algorithmPractice;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class RightBiggestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int[] numbers, results;
        String[] line;
        Stack<Integer> stack = new Stack<>();

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        results = new int[n];
        Arrays.fill(results, -1);

        line = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                results[idx] = numbers[i];
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) bw.write(results[i] + " ");
        bw.flush();
        bw.close();
    }
}
