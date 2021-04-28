package inflearn;

import java.util.Scanner;

public class Problem41 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        int month = Integer.parseInt(line[0]);
        int day = Integer.parseInt(line[1]);

        CalculateDate date = new CalculateDate(month, day);
        date.mainLogic();
    }
}

class CalculateDate {

    private int month;
    private int day;
    private int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String[] s = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public CalculateDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    void mainLogic() {
        int m = month - 1;
        int a = day-1;
        for(int i=0; i<m; i++) {
            a+=d[i];
        }

        a = a % 7;

        System.out.println(s[a]);
    }
}
