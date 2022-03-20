package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficient {

    public static void main(String[] args) throws IOException {
        int n=0,k=0,result=0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);

        if(k < 0) {
            result = 0;
        }
        else if(k > n) {
            result = 0;
        }
        else {
            result = factorial(n) / (factorial(k)*factorial(n-k));
        }

        System.out.println(result % 1000000007);
    }

    private static int factorial(int num) {
        int total = 1;

        for(int i=2; i<=num; i++) {
            total = (total * i) % 1000000007;
        }

        return total;
    }
}
