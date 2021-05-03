class Main {
    public int solution(int n) {
        int answer = 0;
        int cnt = 1;
        int direction = 0;
        int aim = n;
        int i = 0,
        j = 0;
        for (int number = 1; number <= (n * n); number ++) {
            if (i == j) 
                answer += number;
            
            if (cnt == aim) {
                direction ++;
                if (direction == 1) 
                    aim --;
                
                if (direction == 3) 
                    aim --;
                
                if (direction == 4) 
                    direction = 0;
                
                cnt = 0;
            }
            switch (direction) {
                case 0:
                    j ++;
                    break;
                case 1:
                    i ++;
                    break;
                case 2:
                    j --;
                    break;
                case 3:
                    i --;
                    break;
            }
            cnt ++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int ret1 = sol.solution(n1);
        System.out.println(ret1);
        int n2 = 2;
        int ret2 = sol.solution(n2);
        System.out.println(ret2);
    }
}
