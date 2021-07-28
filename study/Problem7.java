package study;

import java.util.HashMap;

public class Problem7 {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++) {
            if(isLearn(skill_trees[i], skill)) answer++;
        }

        return answer;
    }

    private boolean isLearn(String skillTree,  String skill) {
        skillTree = skillTree.replaceAll("[^" + skill + "]", "");
        return skillTree.startsWith(skill);
    }
}
