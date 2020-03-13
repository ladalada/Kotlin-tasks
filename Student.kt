fun main(args: Array<String>) {
    var student1 = Student("Bob", 1)
    var student2 = Student("Alice", 2)
    var student3 = Student("Anna", 1)
    var student4 = Student("Tom", 3)
    var student5 = Student("Tony", 4)
    var student6 = Student("Mary", 3)
    var student7 = Student("Mark", 2)
    var student8 = Student("Jane", 1)
    var student9 = Student("Kate", 1)
    var student10 = Student("Rob", 4)

    printStudents(listOf(student1, student2, student3, student4, student5,
        student6, student7, student8, student9, student10), 2)
}

class Student {
    private var studentName: String? = null
    private var studentCourse: Int? = null

    constructor()

    constructor(_name: String, _course: Int) {
        this.studentName = _name
        this.studentCourse = _course
    }

    fun getName(): String? {
        return this.studentName
    }

    fun getCourse(): Int? {
        return this.studentCourse
    }
}

fun printStudents(studentsList: List<Student>, course: Int) {
    for (st in studentsList) {
        if (st.getCourse() == course) {
            println(st.getName())
        }
    }
}