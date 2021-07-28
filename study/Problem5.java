package study;

import java.util.Arrays;

public class Problem5 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Problem5 problem5 = new Problem5();
        int[] answer = problem5.solution(array, commands);

        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + ",");
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for(int i=0; i<commands.length; i++) {
            answer[i] = calculate(array, commands[i]);
        }

        return answer;
    }

    int calculate(int[] array, int[] command) {
        int[] copyArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
        Arrays.sort(copyArray);
        return copyArray[command[2]-1];
    }
}


