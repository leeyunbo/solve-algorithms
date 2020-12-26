package algorithmPractice;

/*
 * https://www.acmicpc.net/source/24636519
 * 백준 1021번 회전하는 큐 문제 풀이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotationQueue {
    static int[] loc;
    static int listSize;
    static boolean[] isNotExist;
    public static void main(String[] args) throws IOException {
        int aimCnt, result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        listSize = Integer.parseInt(line[0]);
        aimCnt = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        loc = new int[aimCnt];
        for(int i=0; i<loc.length; i++)
            loc[i] = Integer.parseInt(line[i]);


        isNotExist = new boolean[aimCnt];

        for(int i=0; i<loc.length; i++) {
            int temp = loc[i];
            int left = temp - 1;
            int right = listSize + 1 - temp;
            System.out.println("left, right : " + left + "," + right);
            if(left < right) {
                System.out.println("move left : " + left);
                moveLeft(left);
                result += left;
            }
            else {
                System.out.println("move right : " + right);
                moveRight(right);
                result += right;
            }

            for(int j=0; j<loc.length; j++) {
                System.out.print(loc[j]+ ",");
            }
            System.out.println();
            System.out.println("Poll and move Left : -1");
            moveLeft(1);
            isNotExist[i] = true;
            listSize = listSize - 1;
            loc[i] = 0;

            for(int j=0; j<loc.length; j++) {
                System.out.print(loc[j]+ ",");
            }
            System.out.println();
            System.out.println("--------------------");
        }

        System.out.println(result);
    }

    static void moveLeft(int move) {
        if(move == 0) return;

        for(int i=0; i<loc.length; i++)
            if(!isNotExist[i]) {
                int temp = loc[i] - move;
                if(loc[i] - move < 1)
                    loc[i] = listSize - Math.abs(temp);
                else loc[i] = temp;

            }
    }

    static void moveRight(int move) {
        for(int i=0; i<loc.length; i++)
            if(!isNotExist[i])
                loc[i] = (loc[i] + move) % listSize;

    }
}


