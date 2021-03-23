package algorithmPractice;

/*
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력 한다.
단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
뒤집는 함수인 int reverse(int x) 와 소수인지를 확인하는 함수 bool isPrime(int x)를 반드시 작성하여 프로그래밍 한다.
 */

import java.io.*;
import java.util.Scanner;

public class Problem13 {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        ReversePrimeNumberModule module = new ReversePrimeNumberModule();


        int n = scanner.nextInt();

        for(int i=0; i<n; i++) {
            int x = module.reverse(scanner.nextInt());
            if(module.isPrime(x)) {
                bw.write(x + " ");
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}



class ReversePrimeNumberModule {

    boolean isPrime(int x) {
        if(x==1) return false;
        
        // 1. 1~ N까지 모든 수를 나눴을 떄, 1이랑 본인으로만 나뉘어지는 경우 소수이다.
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x%i==0) {
                return false;
            }
        }

        return true;
    }

    int reverse(int x) {
        String strX = String.valueOf(x);
        StringBuilder sb = new StringBuilder();

        for(int i=strX.length()-1; i>=0; i--) {
            sb.append(strX.charAt(i));
        }

        return Integer.valueOf(sb.toString());
    }

}
