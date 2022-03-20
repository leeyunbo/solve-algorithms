package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InteligenceTrain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int temp = 0;
        for(int i=0; i<10; i++) {
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            temp += numbers[1] - numbers[0];
            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}
