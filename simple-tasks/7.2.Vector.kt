/**
 * Общая постановка задач
 *
 * В нижеприведенных задачах необходимо разработать объявление класса и описание класса.
 * В объявлении и описании класса должны быть реализованы указанные методы.
 * (При реализации методов необходимо реализовать указанные исключения.)
 * Также необходимо разработать необходимые конструкторы.
 *
 * Тестовая функция main должна содержать объявления не менее двух объектов тестируемого класса.
 * (При использовании методов объекта необходимо продемонстрировать обработку исключительной ситуации.)
 */

/**
 * Вариант B
 *
 * Разработайте класс вектор из 10 элементов
 * и реализуйте метод сложения элементов векторов.
 * В классе реализовать конструктор копирования.
 * При реализации методов предполагается, что методы нельзя вызвать,
 * если размеры суммируемых векторов не совпадают.
 */

fun correctSize(v: MutableList<Double>): Boolean {
    if (v.size != 10) return false
    return true
}

fun main(args: Array<String>) {
    println("vector1")
    var vector1 = Vector()
    vector1.printVector()

    println("vector2")
    var v2: MutableList<Double> = mutableListOf(2.3, 5.2, 7.5, 3.5)
    var vector2: Vector? = null
    if(correctSize(v2)){
        vector2 = Vector(v2)
    } else {
        println("Wrong size")
    }
    if (vector2 !== null) {
        vector2.printVector()
    }

    var vector3 = Vector(mutableListOf(2.3, 5.2, 7.5, 3.5, 26.4, 21.2, 65.3, 43.2, 53.5, 65.2))
    println("vector3")
    vector3.printVector()

    var vector4 = Vector(mutableListOf(10.2, 30.2, 10.2, 40.1, 10.4, 10.0, 60.3, 40.2, 50.1, 60.2))
    println("vector4")
    vector4.printVector()

    println("Sum of two vectors:")
    vector3.twoVectorsSum(vector4).printVector()

    var vector5 = Vector(vector4)
    println("vector5")
    vector5.printVector()
}

class Vector {
    var vector = MutableList(10, {i -> 0.0})

    constructor()

    constructor(_list: MutableList<Double>): this() {
        if (_list.size == 10) {
            this.vector = _list
        } else {
            println("Wrong")
        }
    }

    fun printVector() {
        for (i in 0..9) {
            print(vector[i])
            print(" ")
        }
        println()
    }

    fun twoVectorsSum(v2: Vector): Vector {
        var sum: MutableList<Double> = mutableListOf()
        for (i in 0..9) {
            sum.add(vector[i] + v2[i])
        }
        var sumVector = Vector(sum)
        return sumVector
    }

    private operator fun get(i: Int): Double {
        return vector[i]
    }

    constructor(other: Vector): this(other.vector) {
    }
}
