package algorithmPractice;

/*
 * https://www.acmicpc.net/problem/1966
 * 백준 프린터 큐
 */

import java.io.IOException;
import java.util.*;

public class PrinterQueue {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String result = "";
        int tc = sc.nextInt();

        for(int i=0; i<tc; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Document[] documents = new Document[N];
            List<Integer> pList = new ArrayList<>();
            Queue<Document> printQueue = new LinkedList<>();
            for(int j=0; j<documents.length; j++) {
                int priority = sc.nextInt();
                pList.add(priority);
                documents[j] = new Document(priority, j);
                printQueue.add(documents[j]);
            }


            result += print(printQueue, pList, M) + "\n";
        }

        System.out.print(result);
    }

    static void rSort(List<Integer> pList) {
        Collections.sort(pList, (o1, o2) -> {
            if(o1 > o2) return -1;
            else if(o1 < o2) return 1;
            else return 0;
        });
    }

    static int print(Queue<Document> printQueue, List<Integer> pList, int M) {
        int count = 0;

        rSort(pList);
        while(!printQueue.isEmpty()) {
            Document document = printQueue.poll();
            if(document.priority == pList.get(0)) {
                count++;
                if(M == document.num) return count;
                pList.remove(0);
            }
            else
                printQueue.add(document);
        }

        return -1;
    }
}

class Document {
    public int num;
    int priority;

    public Document(int _priority, int _num) {
        priority = _priority;
        num = _num;
    }
}
