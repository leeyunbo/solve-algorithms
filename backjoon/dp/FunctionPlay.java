package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/9184
 * 백준 9184번 신나는 함수 실행
 */

import java.io.*;

public class FunctionPlay {

    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            if(a == -1 && b == -1 && c == -1) break;

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if(dp[a+50][b+50][c+50] != 0)
            return dp[a+50][b+50][c+50];

        if (a > 20 || b > 20 || c > 20)
            return dp[a+50][b+50][c+50] = w(20, 20, 20);

        if (a < b && b < c)
            return dp[a+50][b+50][c+50] = w(a, b, c-1) + w (a, b-1, c-1) - w(a, b-1, c);

        return dp[a+50][b+50][c+50] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
