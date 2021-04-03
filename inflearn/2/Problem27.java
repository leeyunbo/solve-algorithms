import java.util.Arrays;

public class Two {

    public static void main(String[] args) {

        int[][] needs = {{1,1}, {1,1}};
        int r = 2;

        int answer = 0;

        Factory factory = new Factory(needs, r);
        answer = factory.mainLogic();

        System.out.println(answer);


    }
}

class Factory {

    private int[][] needs;
    private int r;

    // 최악의 경우 15C2 15 X 14 = 250 * 1000

    public Factory(int[][] _needs, int _r) {
        needs = _needs;
        r = _r;
    }

    int mainLogic() {
        int result = 0;

        int[] sum = new int[needs[0].length];
        int[] select = new int[needs[0].length];

        for(int i=0; i<needs.length; i++) {
            for(int j=0; j<needs[i].length; j++) {
                sum[j] += needs[i][j];
            }
        }

        Arrays.sort(sum);
        for(int i=sum.length-1, j=0; i>=0; i--,j++) {
            select[j] = sum[i];
        }


        for(int i=select.length-1; i>select.length-r; i--) {
            select[i] = 0;
        }

        for(int i=0; i<needs.length; i++) {
            int[] need = new int[needs[i].length];
            for(int j=0; j<needs[i].length; j++) {
                if(needs[i][j] == 1) {
                    need[j]++;
                }
            }

            boolean isPossible = true;
            for(int k=0; k<need.length; k++) {
                if(need[k] == 1 && select[k] == 0) {
                    isPossible = false;
                    break;
                }
                else if(need[k] == 1 && select[k] > 0) {
                    select[k]--;
                }
                else {
                    continue;
                }
            }

            if(isPossible) {
                result++;
            }
        }

        return result;
    }
}
