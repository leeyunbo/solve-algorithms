package backjoon;


import java.util.Scanner;

public class GcdLcm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
}
