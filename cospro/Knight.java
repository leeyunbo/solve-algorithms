class Main {
    public int solution(String pos) {
        int[][] directions = {{ -1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2 }};
        int answer = 0;
        int left = pos.charAt(0) - 65;
        int right = 8 - (pos.charAt(1) - 48);
        for (int i = 0; i < directions.length; i ++) {
            int mLeft = left + directions[i][0];
            int mRight = right + directions[i][1];
            if (mLeft < 0 || mLeft > 7 || mRight < 0 || mRight > 7) 
                continue;
            
            answer ++;
        }
        return answer;
    }
  
    public static void main(String[] args) {
        Main sol = new Main();
        String pos = "A7";
        int ret = sol.solution(pos);
        System.out.println(ret);
    }
}
