package backjoon;

/*
이진수의 1 위치 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            findOne(n);
        }
    }

    private static void findOne(int n) {
        int loc = 0;
        for(int i=1; i<=n; i<<=1) {
            if((n&i)!=0) System.out.print(loc + " ");
            loc++;
        }
    }
}
