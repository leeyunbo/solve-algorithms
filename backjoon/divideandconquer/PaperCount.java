package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1780
 * 백준 1780번 종이의 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaperCount {

    static final int WRONG = -654321;
    static int[][] paper;
    static int[] results = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<line.length; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        cutting(0, 0, n);

        for(int i=0; i<results.length; i++) {
            System.out.println(results[i]);
        }

    }


    static void cutting(int startLeft, int startRight, int length) {
        // base-case
        int result = isSame(startLeft, startRight, length);
        if(result != WRONG) {
            results[result+1]++;
            return;
        }
        else {
            cutting(startLeft, startRight, length/3);
            cutting(startLeft, startRight + length/3, length/3);
            cutting(startLeft, startRight + (length/3)*2, length/3);

            cutting(startLeft + length/3, startRight, length/3);
            cutting(startLeft + length/3, startRight + length/3, length/3);
            cutting(startLeft + length/3, startRight + (length/3)*2, length/3);

            cutting(startLeft + (length/3)*2, startRight, length/3);
            cutting(startLeft + (length/3)*2, startRight + length/3, length/3);
            cutting(startLeft + (length/3)*2, startRight + (length/3)*2, length/3);
        }
    }


    static int isSame(int startLeft, int startRight, int length) {
        int temp = paper[startLeft][startRight];
        for(int i=startLeft; i<startLeft+length; i++) {
            for(int j=startRight; j<startRight+length; j++) {
                if(paper[i][j] != temp) return WRONG;
            }
        }

        return temp;
    }

}
