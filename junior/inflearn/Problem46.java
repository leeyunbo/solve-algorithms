package junior.inflearn;

import java.util.Scanner;

public class Problem46 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        UglyNumbers uglyNumbers = new UglyNumbers(n);
        uglyNumbers.mainLogic();
    }
}

class UglyNumbers {

    private int n;

    public UglyNumbers(int n) {
        this.n = n;
    }

    void mainLogic() {
        int[] a = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;

        a[0] = 1;
        for(int i=1; i<n; i++) {
            int r2 = a[p2] * 2;
            int r3 = a[p3] * 3;
            int r5 = a[p5] * 5;
            int min = Math.min(Math.min(r2, r3),r5);
            a[i] = min;

            if(min == r2) p2++;
            if(min == r3) p3++;
            if(min == r5) p5++;
        }

        System.out.println(a[n-1]);
    }
}
