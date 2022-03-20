package junior.inflearn;

/**
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강 연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다. 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 * 이때 최대 수입을 출력하자.
 *
 * 1. 가장 마지막 날부터 값을 구하도록 한다. (첫날부터 구하게 되면 마지막날, 그 전날에도 가능한 강의를 선택할수도 있음)
 * 2. 해당 날에 가능한 강의들을 우선순위 큐에 넣어서 최선의 강의를 선택한다.
 * 3. 반복하여 수입에 더한다.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem66 {

    public static void main(String[] args) {
        int n, max = 0;
        ArrayList<Item> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            list.add(new Item(money, day));
            max = Math.max(day, max);
        }

        LargestIncomeSchedule largestIncomeSchedule = new LargestIncomeSchedule(max, list);
        largestIncomeSchedule.printIncome();
    }
}

class LargestIncomeSchedule {

    private ArrayList<Item> list;
    private PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
    private int max = 0;

    public LargestIncomeSchedule(int max, ArrayList<Item> list) {
        this.max = max;
        this.list = list;
    }

    void printIncome() {
        int income = 0;

        // 첫째날부터 구하게 되면 셋째날, 둘째날에도 가능한 가장 큰 값을 선택하는 경우가 생겨버림
        for(int i=max; i>=1; i--) {
            for (Item item : list) {
                if(item.day >= max) priorityQueue.add(item);
            }

            Item best = priorityQueue.poll();
            income += best.money;
            list.remove(best);
            priorityQueue.clear();
            max--;
        }

        System.out.println(income);

    }
}


class Item implements Comparable<Item>{
    int day;
    int money;

    public Item(int money, int day) {
        this.day = day;
        this.money = money;
    }

    @Override
    public int compareTo(Item o) {
        if(o.money > this.money) {
            return 1;
        }
        else if(o.money < this.money) {
            return -1;
        }
        else return 0;
    }
}
