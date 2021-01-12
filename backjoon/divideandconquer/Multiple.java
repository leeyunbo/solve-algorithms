package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1629
 * 백준 1629번 곱셈
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple {

    public static void main(String[] args) throws IOException {
        int A,B,C;
        String[] line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");

        A = Integer.parseInt(line[0]);
        B = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);

        System.out.println(pow(A, B, C));
    }

    static long pow(int a, int b, int c) {
        if(b == 1) return a % c;

        long common = pow(a, b/2, c);

        if(b % 2 == 0) return (common * common) % c;
        else return ((common * common) % c * a) % c;
    }
}
