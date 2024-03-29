package backjoon;

import java.util.Scanner;

public class Fibonacci5 {
    static int[] cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cache = new int[n+1];
        System.out.println(fib(n));
    }


    private static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(cache[n] > 0) return cache[n];
        return cache[n] = fib(n-1) + fib(n-2);
    }
}
