package junior.programmers.study;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5,4,2,5,2,1,2,3,2,4,2,5};
        Problem1 problem1 = new Problem1();
        int[] answer = problem1.solution(answers);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int[] answers) {
        int[][] answerOfStudents = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        Student[] students = new Student[answerOfStudents.length];
        for(int i=0; i<students.length; i++) {
            students[i] = new Student(answerOfStudents[i], i+1);
        }

        getCorrectCntOfStudents(students, answers);
        return getWinner(students);
    }

    void getCorrectCntOfStudents(Student[] students, int[] answers) {
        for (Student student : students) {
            for(int i=0; i<answers.length; i++) {
                if(answers[i] == student.answer[i%student.answer.length]) student.correct++;
            }
        }
    }

    int[] getWinner(Student[] students) {
        int same = 1;
        Arrays.sort(students);

        for(int i=0; i<students.length-1; i++) {
            if(students[i].correct == students[i+1].correct) same++;
            else break;
        }

        int[] answer = new int[same];
        for(int i=0; i<same; i++) {
            answer[i] = students[i].number;
        }

        return answer;
    }
}

class Student implements Comparable<Student> {
    public int[] answer;
    public int number;
    public int correct;

    public Student(int[] answer, int number) {
        this.answer = answer;
        this.number = number;
        this.correct = 0;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.correct, this.correct);
    }
}
