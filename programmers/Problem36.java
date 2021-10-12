package navercloud;

import java.util.*;

/**
 *   XY..
 *   YX..
 *   ..YX
 *   .AXY
 *
 *   연결된 영토(대륙)에서 전쟁이 발생하는데, 가장 많은 영토를 가지고 있는 나라가 최종적으로 점령하게 된다.
 *   그런데 해당 대륙에서 동일한 크기의 영토를 가지고 있는 나라들이 있을 경우 사전 순으로 정렬했을 때 가장 맨 앞에 있는 나라가 동일한 크기의 영토를 제외한 나라들을 점령하게 된다.
 *
 *   이 전쟁들이 모든 대륙에서 발생한다고 할 때, 최종적으로 가장 큰 영토를 가진 나라의 영토 크기를 반환하세요.
 */

public class Problem36 {

    private static int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.solution(new String[] {"XY..", "YX..", "..YX", ".AXY"}));
    }

    public int solution(String[] maps) {
        boolean[][] check = new boolean[maps.length][maps[0].length()];
        HashMap<Character, Integer> resultMap = new HashMap<>();

        // 모든 대륙에 대하여 전쟁 시뮬레이션을 수행한다.
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(!check[i][j] && maps[i].charAt(j) != '.') {
                    warSimulation(i, j, maps, check, resultMap);
                }
            }
        }

        // 가장 큰 크기의 영토를 가진 나라의 영토 크기를 반환한다.
        List<Character> results = new ArrayList<>(resultMap.keySet());

        results.sort((o1, o2) -> resultMap.get(o2).compareTo(resultMap.get(o1)));

        return resultMap.get(results.get(0));
    }

    private void bfs(int tempLeft, int tempRight, String[] maps, boolean[][] check, HashMap<Character, Integer> territoryMap) {
        Queue<Node> queue = new LinkedList<>();

        territoryMap.put(maps[tempLeft].charAt(tempRight), territoryMap.getOrDefault(maps[tempLeft].charAt(tempRight), 0) + 1);
        check[tempLeft][tempRight] = true;
        queue.offer(new Node(tempLeft, tempRight));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int[] dir : dirs) {
                int nextLeft = node.left + dir[0];
                int nextRight = node.right + dir[1];
                if((nextLeft >= 0 && nextRight >= 0 && nextLeft < maps.length && nextRight < maps[0].length())
                        && !check[nextLeft][nextRight]
                        && maps[nextLeft].charAt(nextRight) != '.') {
                    queue.offer(new Node(nextLeft, nextRight));
                    territoryMap.put(maps[nextLeft].charAt(nextRight), territoryMap.getOrDefault(maps[nextLeft].charAt(nextRight), 0) + 1);
                    check[nextLeft][nextRight] = true;
                }
            }
        }
    }


    private void warSimulation(int startLeft, int startRight, String[] maps, boolean[][] check, HashMap<Character, Integer> resultMap) {
        HashMap<Character, Integer> territoryMap = new HashMap<>();

        // 해당 대륙에 존재하는 모든 나라들의 영토 개수가 입력된다.
        bfs(startLeft, startRight, maps, check, territoryMap);

        // 그 대륙에 존재하는 나라를 모두 가져와서, 영토 크기를 기준으로 내림차순 정렬한다.
        // 만약 같다면 나라의 이름 사전에서 앞에 나오는 순으로 정렬한다.
        List<Character> territories = new ArrayList<>(territoryMap.keySet());
        territories.sort((o1, o2) -> {
            if (territoryMap.get(o1) > territoryMap.get(o2)) {
                return -1;
            } else if (territoryMap.get(o1) < territoryMap.get(o2)) {
                return 1;
            } else {
                return o2.compareTo(o1);
            }
        });

        // 전쟁이 이루어진 후의 영토 현황을 최신화 시켜준다.
        addOccupiedTerritory(territories, territoryMap);

        // 모든 대륙의 영토 현황에 해당 대륙의 영토 현황을 취합한다.
        for(Character territory : territories) {
            resultMap.put(territory, resultMap.getOrDefault(territory, 0) + territoryMap.get(territory));
        }
    }

    private void addOccupiedTerritory(List<Character> territories, HashMap<Character, Integer> territoryMap) {
        int draw = 0;
        int occupiedTerritory = 0;

        // 가장 많은 영토를 가진 나라를 뽑아온 후에, 동일한 크기의 영토를 가진 나라의 개수를 구한다.
        int winnerTerritory = territoryMap.get(territories.get(0));
        for(Character territory : territories) {
            if(territoryMap.get(territory) == winnerTerritory) draw += 1;
        }

        // 동일한 크기의 영토를 가진 나라를 제외한 다른 나라들의 영토 크기를 모두 더한다.
        for(int i=draw; i<territories.size(); i++) {
            int territory = territoryMap.get(territories.get(i));
            occupiedTerritory += territory;
            territoryMap.put(territories.get(i), 0);
        }

        territoryMap.put(territories.get(0), territoryMap.get(territories.get(0)) + occupiedTerritory);
    }

    class Node {
        private int left;
        private int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}
