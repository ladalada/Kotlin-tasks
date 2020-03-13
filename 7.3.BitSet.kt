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
 * Вариант С
 *
 * Необходимо разработать класс хранения битовых множеств
 * максимум из 100 элементов.
 * В разработанном классе реализуйте метод объединение  множеств.
 * В классе реализовать инициализирующий конструктор.
 * При реализации методов предполагается, что методы нельзя вызвать,
 * если мощности множеств не совпадают.
 */

/**
 * битовое множество из 0 и 1 подряд, в строке 
 */

fun main(args: Array<String>) {
    var test1 = BitSet("11")
    test1.printBitSet()

    var test2 = BitSet("10")
    test2.printBitSet()

    println("Union:")
    println(test1.unionOfSets(test2))
}

class BitSet {
    var bitSet: String? = null

    constructor()

    constructor(_string: String) {
        if(_string.length <= 100) {
            var correct: Boolean = true
            for (c in _string) {
                if (c != '0' && c != '1') {
                    println("Wrong character")
                    correct = false
                    break
                }
            }
            if (correct) {
                this.bitSet = _string
            }
        }
    }

    fun printBitSet() {
        println(bitSet)
    }

    private fun bitSetSize(): Int {
        return bitSet?.length ?: -1
    }

    private fun returnBitSet(): String? {
        return bitSet
    }

    fun unionOfSets(bs: BitSet): String {
        return if (this.bitSetSize() >= 0 && bs.bitSetSize() >= 0) {
            if (this.bitSetSize() == bs.bitSetSize()) {
                (bitSet + bs.returnBitSet())
            } else {
                println("Different sizes")
                ""
            }
        } else {
            println("Wrong character in bit sets")
            ""
        }
    }
}