package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/5430
 * 백준 AC
 */

import java.io.*;
import java.util.ArrayDeque;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            AC_L ac = new AC_L(input, function, n);
            bw.write(ac.play() + '\n');
        }

        bw.flush();
        bw.close();
    }
}


class AC_L {

    String[] arrInput;
    String function;
    String input;
    int n;

    public AC_L(String _input, String _function, int _n) {
        input = _input;
        function = _function;
        n = _n;
    }

    void initialized() {
        arrInput = input.replace("[","").replace("]","").split(",");
    }

    String play() {
        initialized();

        boolean isReverse = false;
        int left = 0, right = n-1;
        for(int i=0; i<function.length(); i++) {
            switch (function.charAt(i)) {
                case 'R' :
                    isReverse = !isReverse;
                    break;
                case 'D' :
                    if(left > right) return "error";
                    if(isReverse) right--;
                    else left++;
                    break;
                default :
                    break;
            }
        }

        return queue_toString(isReverse, left, right);
    }


    String queue_toString(boolean isReverse, int left, int right) {
        if(left > right) return "[]";

        StringBuilder result = new StringBuilder("[");
        if(!isReverse) {
            for(int i=left; i<=right; i++) {
                if(i != right) result.append(arrInput[i] + ",");
                else result.append(arrInput[i]);
            }
        }
        else {
            for(int i=right; i>=left; i--) {
                if(i != left) result.append(arrInput[i] + ",");
                else result.append(arrInput[i]);
            }
        }

        result.append("]");

        return result.toString();
    }
}
