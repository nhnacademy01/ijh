package stream;

import java.util.Comparator;
import java.util.List;

public class StreamSort {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Jordan", 3, 300),
                new Student("Comtin", 1, 200),
                new Student("Coco", 2, 100),
                new Student("Manty", 2, 150),
                new Student("Marco", 1, 200),
                new Student("Dongmyo", 3, 290),
                new Student("Ocean", 3, 180)
        );
//        students.stream()
//                .sorted(Comparator.comparing(Student::getClass)
//                        .sorted(Comparator.naturalOrder())
//                        .forEach(System.out::println);
        //         students.stream().sorted().forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int clazz;
    int totalScore;

    Student(String name, int clazz, int totalScore) {
        this.name = name;
        this.clazz = clazz;
        this.totalScore = totalScore;
    }

    // 총점 내림차순 정렬
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

    // getters...
}