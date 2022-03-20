package junior.javapractice;

import java.util.Comparator;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("이파이썬", 1, 200),
                new Student("이씨샾", 2, 400),
                new Student("이씨", 4, 450),
                new Student("이비베", 5, 500)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 기본 정렬
                .forEach(System.out::println);
    }
}


class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    String getName() { return name; }
    int getBan() { return ban; }
    int getTotalScore() { return totalScore; }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
