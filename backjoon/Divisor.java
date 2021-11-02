package backjoon;

import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                cnt++;
            }

            if(k == cnt) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }
}
