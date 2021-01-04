/*
 * https://www.acmicpc.net/problem/1992
 * 백준 1992번 쿼드트리
 */

package algorithmPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    static int[][] array;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            String line = br.readLine();
            for(int j=1; j<=line.length(); j++) {
                array[i][j] = line.charAt(j-1) - '0';
            }
        }

        zip(1, 1, n, n);

        System.out.println(result);
    }


    static void zip(int sX, int sY, int eX, int eY) {
        if(isSame(sX, sY, eX, eY)) {
            result.append(array[sX][sY]);
            return;
        }
        else {
            result.append("(");
            zip(sX, sY, (sX + eX) / 2, (sY + eY) / 2);
            zip(sX, (sY + eY) / 2 + 1, (sX + eX) / 2, eY);
            zip((sX + eX) / 2 + 1, sY, eX, (sY + eY) / 2);
            zip((sX + eX) / 2 + 1, (sY + eY) / 2 + 1, eX, eY);
            result.append(")");
        }
    }

    static boolean isSame(int sX, int sY, int eX, int eY) {
        boolean isSame = true;

        for(int i=sX; i<=eX; i++) {
            for(int j=sY; j<=eY; j++) {
                if(array[i][j] != array[sX][sY]) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }

        return isSame;
    }
}
