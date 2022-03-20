package junior.inflearn;

/*
탄소(C)와 수소(H)로만 이루어진 화합물을 탄화수소라고 합니다.
탄소(C) 한 개의 질량은 12g, 수소(H) 한 개의 질량은 1g입니다. 에틸렌(C2H4)의 질량은 12*2+1*4=28g입니다.
메탄(CH4)의 질량은 12*1+1*4=16g입니다.
탄화수소식이 주어지면 해당 화합물의 질량을 구하는 프로그램을 작성하세요.

 */

import java.util.Scanner;

public class Problem29 {

    public static void main(String[] args) {
        String line;
        Scanner sc = new Scanner(System.in);

        line = sc.nextLine();
        CHWeight chWeight = new CHWeight(line);
        chWeight.mainLogic();
    }
}

class CHWeight {

    private String line;

    public CHWeight(String _line) {
        line = _line;
    }

    void mainLogic() {

        int total = 0, j;
        String number;

        for(int i=0; i<line.length(); i++) {
            char temp = line.charAt(i);
            number = "";
            j = 2;
            if(temp == 'C') {
                if(i == line.length()-1) {
                    total += 12;
                }
                else if(line.charAt(i+1) == 'C' || line.charAt(i+1) == 'H') {
                    total += 12;
                }
                else {
                    number += line.charAt(i+1);
                    while((i+j < line.length() && line.charAt(i+j) != 'C' && line.charAt(i+j) != 'H')) {
                        number += line.charAt(i+j);
                        j++;
                    }
                    total += (12 * (Integer.parseInt(number)));
                }
            }
            else if(temp == 'H') {
                if(i == line.length()-1) {
                    total += 1;
                }
                else if(line.charAt(i+1) == 'C' || line.charAt(i+1) == 'H') {
                    total += 1;
                }
                else {
                    number += line.charAt(i+1);
                    while((i+j < line.length() && line.charAt(i+j) != 'C' && line.charAt(i+j) != 'H')) {
                        number += line.charAt(i+j);
                        j++;
                    }
                    total += (1 * (Integer.parseInt(number)));
                }
            }
        }

        System.out.println(total);
    }
}
