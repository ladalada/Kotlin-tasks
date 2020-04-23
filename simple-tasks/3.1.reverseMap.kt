/**
 * Работа с ассоциативными массивами (Maps).
 *  По заданному ассоциативному массиву "студент"-"оценка за экзамен"
 *  построить обратный массив "оценка за экзамен"-"список студентов с этой оценкой".
 *  Например:    buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
 *  -> mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат"))
 */

fun main(args: Array<String>) {
    var studentGrade: Map<String, Int> = mapOf("Marat" to 3, "Semen" to 5, "Michael" to 5, "George" to 3)
    println(buildGrades(studentGrade))
}

fun buildGrades(studentGrade: Map<String, Int>): Map<Int, List<String>> {
    var gradeList: MutableList<Int> = mutableListOf()
    for (pair in studentGrade) {
        if (!(pair.value in gradeList)) {
            gradeList.add(pair.value)
        }
    }
    var gradeStudent: MutableMap<Int, List<String>> = mutableMapOf()
    for (grade in gradeList) {
        var studentList: MutableList<String> = mutableListOf()
        for (pair in studentGrade) {
            if (pair.value == grade) {
                studentList.add(pair.key)
            }
        }
        gradeStudent.put(grade, studentList)
    }
    return gradeStudent
}
