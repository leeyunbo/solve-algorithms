package algorithmPractice;

/*
 * acmicpc.net/problem/13305
 * 백준 13305번 주유소 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OilStation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long [] line = new long[n-1];
        long[] city = new long[n];
        long total;


        String[] str_line = br.readLine().split(" ");
        for(int i=0; i<line.length; i++) {
            line[i] = Integer.parseInt(str_line[i]);
        }

        String[] str_city = br.readLine().split(" ");
        for(int i=0; i<city.length; i++) {
            city[i] = Integer.parseInt(str_city[i]);
        }

        long temp = city[0];
        total = temp * line[0];
        for(int i=1; i<line.length; i++) {
            if(temp < city[i]) {
                total += temp * line[i];
            }
            else {
                temp = city[i];
                total += city[i] * line[i];
            }
        }

        System.out.println(total);
    }
}
