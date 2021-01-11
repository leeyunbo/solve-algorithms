package algorithmPractice;

import java.util.Scanner;

public class Factorization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for(int i=2; i<=number; i++) {
            while(number % i == 0) {
                number /= i;
                System.out.println(i);
            }
        }

    }
}
