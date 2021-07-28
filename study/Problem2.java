package study;

public class Problem2 {
    public static void main(String[] args) {
        String dirs = "RLDU";

        Problem2 problem2 = new Problem2();
        //System.out.println(problem2.solution(dirs));

    }
}
/*
    public int solution(String dirs) {
        int answer = 0;
        Character character = new Character();

        for(int i=0; i<dirs.length(); i++) {
            answer += getDistance(dirs.charAt(i), character);
        }

        return answer;
    }

    private int getDistance(char dir, Character character) {
        return character.move(dir);
    }
}

class Character {
    int x = 5;
    int y = 5;
    boolean[][][] trace = new boolean[4][10][10];

    int move(char dir) {
        int dis = 0;
        switch (dir) {
            case 'U' -> {
                if (this.x + 1 >= 10) return 0;
                dis += draw('U');
                this.x += 1;
            }
            case 'D' -> {
                if (this.x - 1 < 0) return 0;
                dis += draw('D');
                this.x -= 1;
            }
            case 'L' -> {
                if (this.y - 1 < 0) return 0;
                dis += draw('L');
                this.y -= 1;
            }
            case 'R' -> {
                if (this.y + 1 >= 10) return 0;
                dis += draw('R');
                this.y += 1;
            }
        }

        return dis;
    }

    int draw(char dir) {
        switch (dir) {
            case 'L' -> {
                if(trace[0][x][y]) return 0;
                trace[0][x][y] = true;
                trace[2][x][y-1] = true;
            }
            case 'U' -> {
                if(trace[1][x][y]) return 0;
                trace[1][x][y] = true;
                trace[3][x+1][y] = true;
            }
            case 'D' -> {
                if(trace[3][x][y]) return 0;
                trace[3][x][y] = true;
                trace[1][x-1][y] = true;
            }
            case 'R' -> {
                if(trace[2][x][y]) return 0;
                trace[2][x][y] = true;
                trace[0][x][y+1] = true;
            }
        }

        return 1;
    }
} */
