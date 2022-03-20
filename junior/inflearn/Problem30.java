package junior.inflearn;

/*
캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업 을 저장해 놓았다가 필요할 바로 사용해서 처리속도를 높이는 장치이다.
워낙 비싸고 용량이 작아 효율적으로 사용해야 한다. 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
만약 캐시의 사이즈가 5이고 작업이 2 3 1 6 7 순으로 저장 되어있다면, (맨 앞이 가장 최근에 쓰인 작업이고, 맨 뒤는 가장 오랫동안 쓰이지 않은 작업이다.)
1) Cache Miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인 5번 작 업을 CPU가 사용한다면 Cache miss가 되고 모든 작업이 뒤로 밀리고 5번작업은 캐시의 맨앞에 위치한다.52316 (7번 작업은 캐시에서 삭제된다.)
2) Cache Hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용 한다면 Cache Hit가 되고, 3번 앞에 있는 5, 2번 작업은 한 칸 뒤로 밀리고, 3번이 맨 앞으로 위치하게 된다. --->
 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Problem30 {

    public static void main(String[] args) {

        int N, S;
        int[] works;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        works = new int[S];
        for(int i=0; i < works.length; i++) {
            works[i] = sc.nextInt();
        }

        LRU lru = new LRU(N, S, works);
        lru.mainLogic();

    }
}

class LRU {

    private int N;
    private int S;
    private int[] works;

    public LRU(int _N, int _S, int[] _works) {
        N = _N;
        S = _S;
        works = _works;
    }

    void mainLogic() {
        ArrayList<Integer> workQueue = new ArrayList<>();

        for(int work : works) {
            int state = isHit(work, workQueue);
            if(state != -1) {
                if(workQueue.get(0) == work) continue;
                workQueue.remove(state);
                workQueue.add(0, work);
            }
            else {
                workQueue.add(0, work);
                if(workQueue.size() > N) workQueue.remove(N);
            }

            print(workQueue);
        }
    }

    int isHit(int work, ArrayList<Integer> workQueue) {
        for(int i=0; i<workQueue.size(); i++) {
            if(work == workQueue.get(i)) return i;
        }

        return -1;
    }

    void print(ArrayList<Integer> workQueue) {
        for(int i=0; i<workQueue.size(); i++) {
            System.out.print(workQueue.get(i) + " ");
        }

        if(workQueue.size() < N) {
            for(int i=0; i<N-workQueue.size(); i++) {
                System.out.print(0 + " ");
            }
        }

        System.out.println();
    }
}
