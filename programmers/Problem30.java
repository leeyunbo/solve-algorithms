/**
https://programmers.co.kr/learn/courses/30/lessons/60059
*/

package programmers;

public class Problem30 {

    public static void main(String[] args) {
        Problem30 problem30 = new Problem30();
        System.out.println(problem30.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int l = lock.length, n = key.length, e = 0, aim = 0;

        int[][] extensionMatrix = new int[l + 2 * (l - 1)][l + 2 * (l - 1)];
        int[][][] nKeys = new int[4][n][n];

        nKeys[0] = key;
        for(int i=1; i<4; i++) {
            int[][] nKey = rotateRightTheArray(nKeys[i-1]);
            nKeys[i] = nKey;
        }

        e = extensionMatrix.length;
        for(int i=0; i<l; i++) {
            for(int j=0; j<l; j++) {
                extensionMatrix[i + (l-1)][j + (l-1)] = lock[i][j];
                if(lock[i][j] == 0) aim++;
            }
        }

        for(int i=0; i<=e-n; i++) {
            for(int j=0; j<=e-n; j++) {
                for(int[][] nKey : nKeys) {
                    if(unlock(i, j, nKey, extensionMatrix, aim, l)) return true;
                }
            }
        }
        return false;
    }

    private boolean unlock(int startLeft, int startRight, int[][] key, int[][] extensionMatrix, int aim, int l) {
        int n = key.length, cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(key[i][j] == 1 && extensionMatrix[startLeft+i][startRight+j] == 1) return false;
                if(key[i][j] == 1
                        && extensionMatrix[startLeft+i][startRight+j] == 0
                        && (startLeft + i) >= (l-1)
                        && (startLeft + i) <= 2*(l-1)
                        && (startRight + j) >= (l-1)
                        && (startRight + j) <= 2*(l-1)) cnt++;
            }
        }
        return aim == cnt;
    }

    // 회전 시계
    private int[][] rotateRightTheArray(int[][] key) {
        int n = key.length;
        int[][] nKey = new int[n][n];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                nKey[i][j] = key[n - i - 1][j];
            }
        }

        int[][] nnKey = new int[n][n];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                nnKey[i][j] = nKey[j][i];
            }
        }

        return nnKey;
    }
}
