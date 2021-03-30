package inflearn;

/*
N명의 학생의 수학점수가 입력되면 각 학생의 석차를 입력된 순서대로 출력하는 프로그램을 작성하세요.

▣ 입력설명
첫 줄에 N(1<=N<=100)이 입력되고, 두 번째 줄에 수학점수를 의미하는 N개의 정수가 입력된다.
같은 점수가 입력될 경우 높은 석차로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92 점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
점수는 100점 만점이다.
▣ 출력설명
첫 줄에 입력된 순서대로 석차를 출력한다.
 */

import java.util.*;

public class Problem24 {

    public static void main(String[] args) {
        int N;
        Integer[] scores;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        scores = new Integer[N];

        for(int i=0; i<N; i++) {
            scores[i] = sc.nextInt();
        }

        RankingProgram program = new RankingProgram(scores);
        program.getRanking();

    }
}

class RankingProgram {
    Integer[] scores;
    Integer[] originScores;

    public RankingProgram(Integer[] _scores) {
        scores = _scores;
        originScores = new Integer[scores.length];
        for(int i=0; i<scores.length; i++) {
            originScores[i] = scores[i];
        }
    }
    
    void bfGetRanking() {
        Integer[] rank = new Integer[originScores.length];
        Arrays.fill(rank, 1);

        for(int i=0; i< originScores.length; i++) {
            for(int j=0; j<originScores.length; j++) {
                if(originScores[j] > originScores[i]) rank[i]++;
            }
        }

        for(int i=0; i<rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
    }

    void getRanking() {
        int temp = 1, seq = 1;
        int[] rank = new int[101];
        Arrays.sort(scores, (o1, o2) -> {
            if(o1 > o2) return -1;
            else if(o1 < o2) return 1;
            else return 0;
        });


        rank[scores[0]] = temp;
        for(int i=1; i<scores.length; i++) {
            if (scores[i-1] != scores[i]) {
                if(seq == 1) {
                    rank[scores[i]] = ++temp;
                }
                else {
                    temp = temp + seq;
                    rank[scores[i]] = temp;
                }

                seq = 1;
            }
            else {
                rank[scores[i]] = temp;
                seq++;
            }
        }

        for(int i=0; i<originScores.length; i++) {
            System.out.print(rank[originScores[i]] + " ");
        }


    }

}

