package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */

import java.util.*;

public class Problem31 {

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        System.out.println(problem31.solution(new String[][]{{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}}));

    }

    public int solution(String[][] relation) {
        ArrayList<String> candidateKeys = new ArrayList<>();
        dfs(-1, "", relation, candidateKeys);
        return getCntMinimalityCandidate(candidateKeys);
    }

    // 모든 속성의 조합을 구한다.
    private void dfs(int idx, String attributes, String[][] relation, ArrayList<String> candidateKeys) {
        if(attributes.length() > 0 && isCandidateKey(attributes, relation, candidateKeys)) return;
        if(idx == relation[0].length-1) return;

        for(int i=idx+1; i<relation[0].length; i++) {
            dfs(i, attributes + i, relation, candidateKeys);
        }
    }

    // 속성의 조합이 후보키인지 확인한다.
    private boolean isCandidateKey(String attributes, String[][] relation, ArrayList<String> candidateKeys) {
        HashMap<String, Integer> candidateKeyMap = new HashMap<>();

        for(String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for(int i=0; i<attributes.length(); i++) key.append(row[attributes.charAt(i) - '0']);
            candidateKeyMap.put(key.toString(), 1);
        }

        if(candidateKeyMap.size() == relation.length) {
            candidateKeys.add(attributes);
            return true;
        }

        return false;
    }

    private int getCntMinimalityCandidate(ArrayList<String> candidateKeys) {
        boolean[] isRemove = new boolean[candidateKeys.size()];

        candidateKeys.sort(Comparator.comparingInt(String::length));
        for(String candidateKey : candidateKeys) {
            for(String otherCandidateKey : candidateKeys) {
                if(!otherCandidateKey.equals(candidateKey) && isContains(candidateKey, otherCandidateKey))
                    isRemove[candidateKeys.indexOf(otherCandidateKey)] = true;
            }
        }

        int cntNotMinimalityCandidate = 0;
        for(int i=0; i<isRemove.length; i++) {
            if(isRemove[i]) cntNotMinimalityCandidate++;
        }

        return candidateKeys.size() - cntNotMinimalityCandidate;
    }

    private boolean isContains(String candidateKey, String otherCandidateKey) {
        int sameCnt = 0;
        for(int i=0; i<candidateKey.length(); i++) {
            for(int j=0; j<otherCandidateKey.length(); j++) {
                if(candidateKey.charAt(i) == otherCandidateKey.charAt(j)) sameCnt++;
            }
        }
        return sameCnt == candidateKey.length();
    }
}
