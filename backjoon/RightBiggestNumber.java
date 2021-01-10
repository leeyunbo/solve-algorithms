package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightBiggestNumber {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] line = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        for(int i=0; i<n; i++) {
            Boolean isBreak = false;
            for(int j=i+1; j<n; j++) {
                if(numbers[i] < numbers[j]) {
                    result.append(numbers[j] + " ");
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak) result.append(-1 + " ");
        }

        System.out.println(result.toString());



    }
}
