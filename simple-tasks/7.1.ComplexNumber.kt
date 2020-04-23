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
 * Вариант А
 *
 * Разработать класс комплексное число вещественного типа
 * и реализовать методы получения мнимой и реальной части.
 * В классе реализовать инициализирующий конструктор.
 * При реализации методов предполагается, что методы нельзя вызвать,
 * если число не инициализировалось.
 */

fun main(args: Array<String>) {
    val complexNumber1 = ComplexNumber()

    println(complexNumber1.getRealPart)
    println(complexNumber1.getImaginaryPart)

    complexNumber1.realPart = 3.5
    complexNumber1.imaginaryPart = 2.6

    println(complexNumber1.getRealPart)
    println(complexNumber1.getImaginaryPart)

    val complexNumber2 = ComplexNumber(40.6, 734.1)

    println(complexNumber2.getRealPart)
    println(complexNumber2.getImaginaryPart)
}

class ComplexNumber {
    var realPart: Double = 0.0
    var imaginaryPart: Double = 0.0

    constructor()

    val getRealPart: Double
        get() = realPart

    val getImaginaryPart: Double
        get() = imaginaryPart

    constructor(_realPart: Double, _imaginaryPart: Double) : this() {
        realPart = _realPart
        imaginaryPart = _imaginaryPart
    }
}
