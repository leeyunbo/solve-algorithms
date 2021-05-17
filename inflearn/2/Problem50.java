/**
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * ▣ 입력설명
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 * ▣ 출력설명
 * 첫 번째 줄에 YES, NO를 출력한다.
 * (()))( -> 이 경우를 위해서(배열 벗어남) ')' 이게 왔는데 스택이 비어있는 경우 "NO" 출력!
 */

package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Problem49 {

    public static void main(String[] args) {
        String input;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        SmallCompiler compiler = new SmallCompiler(input);
        System.out.println(compiler.compile());
    }
}

class SmallCompiler {

    private String input;
    private Stack<Character> stack = new Stack<>();


    public SmallCompiler(String input) {
        this.input = input;
    }


    String compile() {
        for(int i=0; i<input.length(); i++) {
            char temp = input.charAt(i);

            if(temp == '(') {
                stack.add(temp);
            }
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
           return "YES";
        }
        else return "NO";
    }
}
