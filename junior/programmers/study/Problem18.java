package junior.programmers.study;

public class Problem18 {

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        System.out.println(problem18.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n+1];
        boolean[] isReserve = new boolean[n+1];
        int ok = n;

        for(int i=0; i<lost.length; i++) {
            isLost[lost[i]] = true;
            ok--;
        }

        for(int i=0; i<reserve.length; i++) {
            if(isLost[reserve[i]]) {
                isLost[reserve[i]] = false;
                ok++;
                continue;
            }

            isReserve[reserve[i]] = true;
        }

        return dfs(isLost, isReserve, 1, ok);

    }

    private int dfs(boolean[] isLost, boolean[] isReserve, int seq, int ok) {
        if(seq == isLost.length) return ok;

        int answer = dfs(isLost, isReserve, seq+1, ok);
        if(isReserve[seq]) {
            if(seq != 1 && isLost[seq-1]) {
                isLost[seq-1] = false;
                answer = Math.max(answer, dfs(isLost, isReserve, seq+1, ok+1));
                isLost[seq-1] = true;
            }

            if(seq < isLost.length-1 && isLost[seq+1]) {
                isLost[seq+1] = false;
                answer = Math.max(answer, dfs(isLost, isReserve, seq+1, ok+1));
                isLost[seq+1] = true;
            }
        }

        return answer;
    }
}
