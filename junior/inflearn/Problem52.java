package junior.inflearn;

import java.util.Scanner;

public class Problem52 {

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        RecursionBinaryConverter converter = new RecursionBinaryConverter();
        System.out.println(converter.convert(n));
    }
}

class RecursionBinaryConverter {

    String convert(int n) {
        String answer = "";
        int temp;

        if(n < 2) return answer + n;

        temp = n % 2;
        answer += convert(n/2);
        return answer + temp;
    }
}
