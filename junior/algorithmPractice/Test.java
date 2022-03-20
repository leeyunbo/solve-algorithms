package algorithmPractice;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        System.out.println(22%32);
        String input = "[1,2,3,4]";
        input = input.replace("[","").replace("]","");
        System.out.println(input);
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");

        System.out.println(queue.toString());
    }
}
