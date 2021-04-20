package inflearn;

import java.util.Scanner;

/*
지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지 되어야 한다.
순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다.
즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다.
지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기 로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.

---------------------------------------------------------------------------------------------------
결정 알고리즘을 활용한다.(정답을 결정해놓고 정답이 맞는지 체크해가며 최적의 값을 찾는 알고리즘)
a가 정답이라고 할 때, a보다 큰 값 모두가 정답이 될 수 있다.
어떤 값을 선택했을 때 그 값이 조건에 부합하면, 그 값보다 작은 값들은 모두 정답이 될 가능성이 있다.
가장 최적의 값을 찾는 것이기 때문에 결국에 조건에 부합한 값보다 작은 값들을 모두 체크 해봐야 한다.
따라서 이진 탐색을 이용하여 작은 값들을 모두 체크 해보도록 한다.

반대로 조건에 부합하지 않는 값보다 큰 값들은 모두 정답이 될 가능성이 있다.
 */

public class Problem36 {

    public static void main(String[] args) {
        int[] numbers;
        int n,m, rt = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
            rt += numbers[i];
        }

        DecisionAlgorithm algorithm = new DecisionAlgorithm(numbers, m, rt);
        algorithm.mainLogic();
    }
}

class DecisionAlgorithm {

    private int[] numbers;
    private int m;
    private int rt;

    public DecisionAlgorithm(int[] numbers, int m, int rt) {
        this.numbers = numbers;
        this.m = m;
        this.rt = rt;
    }

    void mainLogic() {
        int lt=1, mid, result = 0;

        // 1. 이진 탐색을 수행한다. (모든 범위 탐색하는 동안 반복한다.)
        while(lt <= rt) {
            mid = (lt+rt)/2;
            // 2. mid가 조건에 부합하면 mid보다 작은 범위에 속하는 정답들에 대해 조건을 확인한다.
            if(count(mid) <= m) {
                result = mid;
                rt = mid-1;
            }
            // 3. mid가 조건에 부합하지 않으면 mid보다 큰 범위에 속하 정답들에 대해 조건을 확인한다.
            else {
                lt = mid+1;
            }
        }

        System.out.println(result);
    }

    // 주요 로직 -> 선택된 정답이 가능한지 확인한다.
    int count(int size) {
        int cnt = 1, sum = 0;
        // 최대한 size를 채우도록 한다. -> 가장 최소의 count를 구할 수 있음 
        for(int i=0; i<numbers.length; i++) {
            if(sum + numbers[i] > size) {
                cnt++;
                sum = numbers[i];
            }
            else {
                sum += numbers[i];
            }
        }

        return cnt;
    }
}
