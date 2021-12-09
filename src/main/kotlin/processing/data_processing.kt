package processing

import streams.*
import java.util.stream.Collectors


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.stream().anyMatch { grade: Grade -> grade.type == GradeType.A }

}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.stream().map { s: Student -> s.age }.collect(Collectors.toList())
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.stream().filter { student: Student -> student.age <= minAge }.collect(Collectors.toList())

}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.stream().filter { student: Student -> student.gender == Gender.MALE }.count()
        .toInt()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.stream().filter { student: Student -> student.gender == Gender.FEMALE }
        .mapToInt { obj: Student -> obj.age }
        .average().asDouble
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return DataProcessor.getStudentAges(students).stream().reduce { x: Int, y: Int -> x * y }.get()

}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.stream().map { i: Grade ->
        i.type.value
    }.filter { i: Int -> i != 0 }.reduce { x: Int, y: Int -> x * y }.get()

}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion
