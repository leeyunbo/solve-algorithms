package junior.programmers;

public class Problem25 {

    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        System.out.println(problem25.solution("BAAAAABBB"));
    }

    public int solution(String name) {
        int answer = 0;
        int loc = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<name.length(); i++) sb.append("A");

        String temp = sb.toString();
        while(!temp.equals(name)) {
            temp = temp.substring(0, loc) + name.charAt(loc) + temp.substring(loc+1);
            int[] locInform = getClosestLocation(temp, name, loc);
            answer = answer + getSmallestClickCnt(name.charAt(loc)) + locInform[0];
            loc = locInform[1];
        }

        return answer;
    }

    private int getSmallestClickCnt(char aim) {
        int downCnt = 0; int upCnt = 0; char downTarget = 'A'; char upTarget = 'A';
        while(downTarget != aim) {
            downTarget = JoyStick.down(downTarget);
            downCnt+=1;
        }
        while(upTarget != aim) {
            upTarget = JoyStick.up(upTarget);
            upCnt+=1;
        }
        return Math.min(downCnt, upCnt);
    }

    private int[] getClosestLocation(String temp, String name, int loc) {
        if(temp.equals(name)) return new int[] {0, 0};
        int left = 0; int right = 0; int leftLoc = loc; int rightLoc = loc;
        while(temp.charAt(leftLoc) == name.charAt(leftLoc)) {
            leftLoc = JoyStick.left(leftLoc, name);
            left+=1;
        }
        while(temp.charAt(rightLoc) == name.charAt(rightLoc)) {
            if(rightLoc == name.length()-1) {
                right = 654321;
                break;
            }
            rightLoc = JoyStick.right(rightLoc, name);
            right+=1;
        }
        return left < right ? new int[] {left, leftLoc} : new int[] {right, rightLoc};
    }


    static class JoyStick {
        static char up(char target) {
            if(target == 'Z') return 'Z';
            return (char) (target + 1);
        }
        static char down(char target) {
            if(target == 'A') return 'Z';
            else return (char) (target - 1);
        }
        static int right(int loc, String name) {
            if(loc == name.length()-1) return loc;
            else return loc+1;
        }
        static int left(int loc, String name) {
            if(loc == 0) return name.length()-1;
            else return loc-1;
        }
    }
}
