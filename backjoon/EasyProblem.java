package backjoon;

import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        int number = 1;
        int s = 0;
        for(int i=1; i<=b; i++) {
            if(i >= a && i <= b) s += number;
            cnt++;
            if(cnt == number) {
                number++;
                cnt=0;
            }
        }

        System.out.println(s);
    }
}
