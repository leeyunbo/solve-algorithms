package algorithmPractice;

// 1. R : 현재 배열을 뒤집는다.
// 2. D : 첫번째 값을 버린다.
// 3. 만약 값이 없는데 D를 사용하면 error를 출력한다.
// [1,1,2,3,5,8] [1,1,2,3,5,8]
// 4
//RDD
//4
//[1,2,3,4]

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class AC {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = sc.nextInt();

        for(int test = 0; test<testcase; test++) {
            String strFunc = sc.next();
            int listLength = sc.nextInt();
            String strList = sc.next();

            // parser
            Character[] strArray = new Character[listLength];
            int i = 0;
            for(int idx=0; idx<strList.length(); idx++) {
                Character temp = strList.charAt(idx);
                if(temp != '[' && temp != ']' && temp != ',')
                    strArray[i++] = temp;
            }

            // main-logic
            boolean isError = false;
            for (int idx = 0; idx < strFunc.length(); idx++) {
                char tempFunc = strFunc.charAt(idx);
                if (tempFunc == 'R')
                    reverse(strArray);
                else {
                    isError = delete(strArray);
                    if (isError) {
                        bw.write("error\n");
                        break;
                    }
                }
            }

            if(isError) continue;

            String result = "[";
            for(int arrayIdx=0; arrayIdx<strArray.length; arrayIdx++) {
                result += "," + strArray[arrayIdx];
                if(arrayIdx == strArray.length -1) {
                    result += "]";
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void reverse(Character[] strArray) {
        Stack<Character> stack = new Stack<>();
        for(int idx=0; idx<strArray.length; idx++) {
            stack.push(strArray[idx]);
        }

        for(int idx=0; idx<strArray.length; idx++) {
            strArray[idx] = stack.pop();
        }
    }

    static boolean delete(Character[] strArray) {
        if(strArray.length == 0) return true;

        for(int idx=strArray.length-1; idx > 0; idx--) {
            strArray[idx-1] = strArray[idx];
        }

        return false;
    }
}
