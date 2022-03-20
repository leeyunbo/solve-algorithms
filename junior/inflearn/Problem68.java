package junior.inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem68 {

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

        FriendChecker checker = new FriendChecker(friends, a, b, n);
        checker.mainLogic();
    }
}

class FriendChecker {

    private ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
    private boolean[] isCheck = new boolean[1001];
    private int a, b, n;

    public FriendChecker(int[][] friends, int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        initialized(friends);
    }

    private void initialized(int[][] friends) {
        for(int i=0; i<=n; i++) {
            adj.add(new LinkedList<>());
        }

        for(int i=0; i<friends.length; i++) {
            adj.get(friends[i][0]).add(friends[i][1]);
            adj.get(friends[i][1]).add(friends[i][0]);
        }
    }

    private boolean isFrined(int start) {
        if(start == b) return true;

        for(int end : adj.get(start)) {
            if(isCheck[end] == false) {
                isCheck[end] = true;
                if(isFrined(end)) return true;
                isCheck[end] = false;
            }
        }

        return false;
    }

    public void mainLogic() {
        if(isFrined(a)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
