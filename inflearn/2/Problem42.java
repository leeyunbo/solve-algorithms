package inflearn;

import java.util.ArrayList;

/*
sentence가 "i love coding"이고 keyword가 "a,b,c"라고 하고 skips = [1,2,3] 이면 
a는 skips[0] = 1이기 때문에 i를 건너뛰고 삽입된다. 따라서 ia love coding이 된다. 
b는 skips[1] = 2이기 때문에 i 뒤 문자들인 l,o를 건너뛰고 삽입된다. 따라서 ia lobve coding이 된다. 
만약 skips가 keyword보다 길다면 순환식으로 진행된다. a,b,c,a,b,c,..... 
조건) 만약 건너뛰는 숫자가 sentence의 문자열을 벗어나게 된다면 삽입하지 않는다. 

sentence, keyword, skips가 주어진다. 이때 암호화된 문자열을 반환하는 코드를 작성해보시오.
 */

public class Problem39 {

    public static void main(String[] args) {
        int[] skips = {0,0,1,2,3,4,5,6,7};

        Checker checker = new Checker("mask", "i love coding", skips);
        String answer = checker.mainLogic();

        System.out.println("인풋 : " + "i love coding");
        System.out.println("출력값 : " + answer);
    }
}

class Checker {

    private ArrayList<Character> list = new ArrayList<>();
    private int[] insert;
    private int[] skips;
    private String keyword;
    private String sentence;

    public Checker(String keyword, String sentence, int[] skips) {
        this.keyword = keyword;
        this.sentence = sentence;
        this.skips = skips;
        initialized();
    }

    void initialized() {
        for(int i=0; i<sentence.length(); i++) {
            list.add(sentence.charAt(i));
        }
        insert = new int[skips.length];
    }

    String mainLogic() {
        String result = "";
        int loc = 0;
        int ke = 0;

        // 삽입 할 위치를 지정한다.
        for(int i=0; i<skips.length; i++) {
            // 1. 삽입할 keyword 알파벳 하나를 가져온다.
            if(ke == keyword.length()) ke = 0;
            char temp = keyword.charAt(ke++);

            // 2. jump 수만큼 건너 뛰어서 삽입할 위치를 배열에 설정한다.
            loc = setInsertLocation(i, temp, loc);
        }

        // 위치에 맞게 삽입 한다.
        ke = 0;
        int keywordInsertCount = 0;
        for(int i=0; i<insert.length; i++) {
            if(insert[i] > sentence.length()) break;

            if(ke == keyword.length()) ke = 0;
            char temp = keyword.charAt(ke++);

            list.add(insert[i] + keywordInsertCount, temp);
            keywordInsertCount++;
        }

        for(char a : list) {
            result += a;
        }

        return result;
    }

    /**
     * 삽입할 위치를 배열에 설정한다.
     * @param sk
     * @return 다음으로 가리킬 위치를 반환한다.
     */
    int setInsertLocation(int sk, char temp, int loc) {
        boolean isStop = false;
        int jump = skips[sk];

        for(int i=0; i<jump; i++) {
            loc++;

            if(sentence.charAt(i) == temp) {
                insert[sk] = loc;
                isStop = true;
            }
        }

        if(isStop == false) insert[sk] = loc;


        return loc;
    }
}
