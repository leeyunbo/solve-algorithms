package inflearn;

import java.util.Scanner;

/**
 *
 * {a,b} 면 a와 b는 친구이며 {a,b} {b,c}면 a와 c는 친구이다.
 * 이때 a와 b가 주어질 때 둘이 친구인지 확인해보세요. 맞으면 YES 아니면 NO를 출력한다.
 * 집합 A와 집합 B가 서로소 집합(교집합이 존재하지 않는)이면 NO이다.
 *
 * Union-Set 방법
 *  + 경로 압축
 *
 *  1. unionNumbers[v]는 v와 이어져 있는 노드를 나타낸다. (경로 압축에 의해서 루트노드를 나타낼수도 있다.)
 *  2. Find(v)를 하게되면 v가 속한 집합의 루트노드 값을 반환받게 된다.
 *  3. 따라서 Find(a)와 Find(b)를 비교하는 것은 같은 루트노드를 가지고 있는 것을 확인하는 것이다. (루트노드가 다르면 다른 집합일 수 밖에 없음)
 *  4. Find(a)를 수행할 때 Find(a)가 자기 자신의 값을 가지고 있지 않는다면 Find(unionNumbers[a])... 재귀 호출을 하게 된다. 이때 자기와 이어져 있는 노드들을 탐색하다가 결국엔 루트 노드에 도달하게 된다.
 *  -> 따라서 결과 값을 unionNumbers[a] = Find(unionNumbers[a])를 하게되면 결국에 경로 압축이 이루어진다. (경로 압축이 이루어진 노드들은 Level1로 압축됨, 루트 노드 바로 아래!)
 */

public class Problem69 {
    public static void main(String[] args) {
        int[][] friends;
        int a,b,n,m;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        friends = new int[m][2];
        for(int i=0; i<m; i++) {
            friends[i][0] = sc.nextInt();
            friends[i][1] = sc.nextInt();
        }
        a = sc.nextInt();
        b = sc.nextInt();

        FriendCheckerUnionSet checker = new FriendCheckerUnionSet(friends, a, b, n);
        checker.mainLogic();
    }
}

class FriendCheckerUnionSet {

    private int a, b, n;
    private int[][] friends;
    private int[] unionNumbers;

    public FriendCheckerUnionSet(int[][] friends, int a, int b, int n) {
        this.friends = friends;
        this.a = a;
        this.b= b;
        this.n = n;
    }

    /**
     * 루트 노드를 찾는다.
     * @param v
     * @return
     */
    protected int Find(int v) {
        // v == unionNumbers[v] -> 특정 집합의 루트노드.
        // v != unionNumbers[v] -> 어떠한 노드와 이어져 있다.
        if(v == unionNumbers[v]) {
            return v;
        }

        // 경로 압축 (루트 노드의 값을 이어져 있는 모든 노드(v보다 뒤에 위치한)에 삽입한다.)
        return unionNumbers[v] = Find(unionNumbers[v]);
    }

    /**
     * 두개의 집합을 합친다.
     * @param a
     * @param b
     */
    protected void union(int a, int b) {
        if(b == unionNumbers[b]) {
            unionNumbers[a] = b;
        }
        else {
            unionNumbers[a] = Find(b);
        }
    }

    public void mainLogic() {
        unionNumbers = new int[n+1];
        for(int i=1; i<=n; i++) {
            unionNumbers[i] = i;
        }

        for(int i=0; i<friends.length; i++) {
            union(friends[i][0], friends[i][1]);
            for(int j=1; j<=n; j++) {
                System.out.print(unionNumbers[j] + " ");
            }
            System.out.println();
        }


        if(Find(a) == Find(b)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
