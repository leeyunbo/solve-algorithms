package junior.inflearn;

/*
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치합니다.
즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다.
 */

import java.util.Scanner;

public class Problem15 {

    public static void main(String[] args) {
        String arg1, arg2;
        Scanner scanner = new Scanner(System.in);

        arg1 = scanner.nextLine();
        arg2 = scanner.nextLine();

        AnagramModule module = new AnagramModule();
        if(module.isAnagram(arg1, arg2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}


class AnagramModule {

    boolean isAnagram(String arg1, String arg2) {
        int[] cnts1 = new int[200];
        int[] cnts2 = new int[200];

        // 1. 두개를 모두 동일한 조건으로 정렬 후 비교 O(NlgN)
        // 2. 갯수만 같으면 되니까, 배열을 이용해서 갯수를 모두 구한 후 배열 비교 O(N + a)
        for(int i=0; i<arg1.length(); i++) {
            cnts1[arg1.charAt(i)-48]++;
        }

        for(int i=0; i<arg2.length(); i++) {
            cnts2[arg2.charAt(i)-48]++;
        }

        for(int i=0; i<cnts1.length; i++) {
            if(cnts1[i] != cnts2[i]) {
                return false;
            }
        }


        return true;
    }
}
