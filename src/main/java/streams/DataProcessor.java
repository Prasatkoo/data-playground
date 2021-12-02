package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(grade -> grade.getType() == GradeType.A);
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().map(s -> s.getAge()).collect(Collectors.toList());
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> student.getAge() <= minAge).collect(Collectors.toList());
    }



    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.MALE).count();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.FEMALE).mapToInt(Student::getAge).average().getAsDouble();
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return getStudentAges(students).stream().reduce((x,y) -> x * y).get();
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().map(i -> i.getType().getValue()).filter(i -> i != 0).reduce((x,y) -> x*y).get();
    }
    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.empty();
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return new ArrayList<>();
    }

    // endregion
}
