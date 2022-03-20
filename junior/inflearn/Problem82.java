package junior.inflearn;

/**
 * NxN 크기의 정글에 토끼 M마리와 어린 사자 심바가 있다. 각 격자칸에는 토끼 한마리가 있거나 없을 수도 있다.
 * 토끼의 크기는 1~9로 이루어져있으며, 사자 심바의 크기는 2이다.
 * 심바는 1초에 상하좌우로 이동할 수 있다.
 *
 * 심바는 자기보다 큰 토끼로 이동할 수 없으며, 자신의 크기보다 작은 토끼를 잡아먹을 수 있다.
 * 심바는 자신의 크기만큼의 토끼들을 잡아먹으면 크기가 +1 된다.
 *
 * 이동 규칙)
 * 1) 더 이상 먹을 수 있는 토끼가 정글에 없다면 이제 심바는 삼촌 스카에게 복수하러 갈 수 있다.
 * 2) 먹을 수 있는 토끼가 딱 한마리라면, 그 토끼를 먹으러 간다.
 * 3) 먹을 수 있는 토끼가 2마리 이상이면, 거리가 가장 가까운 토끼를 먹으러 간다.
 *  1 거리는 심바가 있는 칸에서 먹으려고 하는 토끼가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최소값이다.
 *  2 가장 가까운 토끼가 많으면, 그 중 가장 위쪽에 있는 토끼, 그러한 토끼가 여러 마리라 면, 가장 왼쪽에 있는 토끼를 잡아먹는다.
 *
 *  삼바가 몇 초안에 모든 토끼들을 잡아먹을 수 있을지 구하시오.
 */

import java.util.*;

public class Problem82 {

    public static void main(String[] args) {
        int[][] map;
        int N;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        SimbaGame simbaGame = new SimbaGame(map, N);
        simbaGame.mainLogic();
    }
}


class SimbaGame {

    private Simba simba;
    private int[][] map;
    private int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int N;

    public SimbaGame(int[][] map, int N) {
        this.map = map;
        this.N = N;
        initialized();
    }

    void mainLogic() {
        while(true) {
            List<Rabbit> rabbits = searchRabbit(simba);

            if(rabbits.size() == 0) break;
            if(rabbits.size() == 1) {
                simba.eat(rabbits.get(0), getDistance(rabbits.get(0), simba), map);
            }
            else {
                Rabbit rabbit = getRabbit(rabbits);
                simba.eat(rabbit, getDistance(rabbit, simba), map);
            }
        }

        System.out.println(simba.day);
    }

    void initialized() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 9) {
                    simba = new Simba(i,j);
                    map[i][j] = 0;
                    break;
                }
            }
        }
    }

    Rabbit getRabbit(List<Rabbit> rabbits) {
        List<Rabbit> rabbitList = new ArrayList<>();

        PriorityQueue<Rabbit> priorityQueue = new PriorityQueue<>(new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                if(o1.distance < o2.distance) {
                    return -1;
                }
                else if(o1.distance > o2.distance) {
                    return 1;
                }
                else {
                    if(o1.x < o2.x) {
                        return -1;
                    }
                    else if(o1.x > o2.x) {
                        return 1;
                    }
                    else {
                        if(o1.y < o2.y) {
                            return -1;
                        }
                        else if(o1.y > o2.y) {
                            return 1;
                        }
                        else return 0;
                    }
                }
            }
        });

        for(Rabbit rabbit : rabbits) {
            rabbit.distance = getDistance(rabbit, simba);
            priorityQueue.add(rabbit);
        }


        return priorityQueue.poll();

    }

    List<Rabbit> searchRabbit(Simba simba) {
        List<Rabbit> rabbits = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] > 0 && simba.weight > map[i][j] && map[i][j] != 9) {
                    rabbits.add(new Rabbit(i, j, map[i][j]));
                }
            }
        }

        return rabbits;
    }

    int getDistance(Rabbit rabbit, Simba simba) {
        boolean[][] isChecked = new boolean[N][N];
        Queue<Route> queue = new LinkedList<>();
        queue.add(new Route(simba.x, simba.y, 0));

        while(!queue.isEmpty()) {
            Route temp = queue.poll();
            isChecked[temp.x][temp.y] = true;
            for(int i=0; i<dir.length; i++) {
                int nX = temp.x + dir[i][0];
                int nY = temp.y + dir[i][1];
                if(nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
                if(isChecked[nX][nY] == false && simba.weight >= map[nX][nY]) {
                    if(nX == rabbit.x && nY == rabbit.y)
                        return temp.level+1;

                    queue.add(new Route(nX, nY, temp.level+1));
                    isChecked[nX][nY] = true;
                }
            }
        }

        return -1;
    }
}

class Simba {
    int x, y, weight, eatCnt, day = 0;

    public Simba(int x, int y) {
        this.x = x;
        this.y = y;
        this.weight = 2;
        eatCnt = 0;
    }

    public void eat(Rabbit rabbit, int distance, int[][] map) {
        eatCnt++;
        if(weight == eatCnt) {
            weight++;
            eatCnt = 0;
        }

        this.x = rabbit.x;
        this.y = rabbit.y;
        this.day += distance;
        map[rabbit.x][rabbit.y] = 0;
    }
}

class Rabbit {
    int x;
    int y;
    int distance;

    public Rabbit(int x, int y, int weight) {
        this.x = x;
        this.y = y;
    }
}

class Route {
    int x;
    int y;
    int level;
    public Route(int x, int y, int level) {
        this.x= x;
        this.y = y;
        this.level = level;
    }
}
