package inflearn2;

/**
 * SEND+MORE=MONEY 라는 유명한 복면산이 있습니다. 이 복면산을 구하는 프로그램을 작성 하세요.
 */

public class Problem76 {

    public static void main(String[] args) {
        SendMoreMoney sendMoreMoney = new SendMoreMoney();
        sendMoreMoney.DFS(0);
    }
}


class SendMoreMoney {

    int[] numbers = new int[8];
    boolean[] isCheck = new boolean[10];

    int send() {
        return numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3];
    }

    int more() {
        return numbers[4] * 1000 + numbers[5] * 100 + numbers[6] * 10 + numbers[1];
    }

    int money() {
        return numbers[4] * 10000 + numbers[5] * 1000 + numbers[2] * 100 + numbers[1] * 10 + numbers[7];
    }

    void print() {
        System.out.println("  " + numbers[0] + " " + numbers[1] + " " + numbers[2] + " " + numbers[3]);
        System.out.println("+ " + numbers[4] + " " + numbers[5] + " " + numbers[6] + " " + numbers[1]);
        System.out.println("---------");
        System.out.println(numbers[4] + " " + numbers[5] + " " + numbers[2] + " " + numbers[1] + " " + numbers[7]);
    }

    boolean DFS(int select) {
        boolean result = false;

        if(select == 8) {
            if(numbers[0] == 0 || numbers[4] == 0) return false;
            if(send() + more() == money()) {
                print();
                return true;
            }
            return false;
        }

        for(int i=0; i<=9; i++) {
            if(isCheck[i] == false) {
                isCheck[i] = true;
                numbers[select] = i;
                result = DFS(select + 1);
                if (result) break;
                isCheck[i] = false;
            }
        }

        return result;
    }
}
