package junior.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * NxN의 도시 지도가 있다.
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현된다.
 * M개의 피잣집을 제외하고 모두 폐업 시킨다고 했을 때, 도시 전체의 피자배달거리가 최소가 되는 경우를 구하시오.
 * 어떤 집의 피자 배달 거리는 M개의 피잣집까지 거리 중 최솟값을 말한다.
 *
 * 도시 전체의 피자배달거리는 모든 집들의 피자 배달 거리들을 합한 값이다.
 */

public class Problem78 {

    public static void main(String[] args) {
        ArrayList<PizzaStore> pizzaStores = new ArrayList<>();
        ArrayList<Home> homes = new ArrayList<>();
        int M, N;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int temp = sc.nextInt();
                if(temp == 1) {
                    homes.add(new Home(i, j));
                }
                else if(temp == 2) {
                    pizzaStores.add(new PizzaStore(i, j));
                }
            }
        }

        PizzaDelDist pizzaDelDist = new PizzaDelDist(pizzaStores, homes, M);
        pizzaDelDist.mainLogic();
    }
}

class PizzaDelDist {

    private int minResult = 654321;
    private ArrayList<PizzaStore> pizzaStores;
    private ArrayList<Home> homes;
    private boolean[] isCheck;
    private int M;


    public PizzaDelDist(ArrayList<PizzaStore> pizzaStores, ArrayList<Home> homes, int M) {
        this.pizzaStores = pizzaStores;
        this.homes = homes;
        this.M = M;
        isCheck = new boolean[pizzaStores.size()];
    }

    void mainLogic() {
        DFS(0, 0);
        System.out.println(minResult);
    }

    void DFS(int select, int before) {
        if(select == M) {
            minResult = Math.min(minResult, getPizzaDistance());
            return;
        }

        for(int i=before; i<pizzaStores.size(); i++) {
            if(isCheck[i] == false) {
                isCheck[i] = true;
                DFS(select + 1, i);
                isCheck[i] = false;
            }
        }
    }

    int getPizzaDistance() {
        int pizzaDistance = 0;

        for(int i=0; i<homes.size(); i++) {
            pizzaDistance += calcDistance(i);
        }

        return pizzaDistance;
    }

    int calcDistance(int h) {
        int distance = 654321;

        for(int i = 0; i<isCheck.length; i++) {
            if(isCheck[i] == true)
                distance = Math.min(distance,
                        Math.abs(pizzaStores.get(i).x - homes.get(h).x) + Math.abs(pizzaStores.get(i).y - homes.get(h).y));
        }

        return distance;
    }
}


class PizzaStore {
    int x,y;
    public PizzaStore(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Home {
    int x,y;
    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
