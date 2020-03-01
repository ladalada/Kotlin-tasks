/**
 * Работа со списками.
 * Рассчитать среднее арифметическое элементов списка list.
 * Вернуть 0.0, если список пуст.
 */

import java.lang.ClassCastException
import java.lang.NullPointerException

fun main(args: Array<String>) {
    arithmeticMeanOfListItems()
}

fun arithmeticMeanOfListItems() {
    val listOfNumbers = listOf(1, 260, 4, 5.6, 0.2, 10)
    println(listOfNumbers)

    try {
        println(arithmeticMean(listOfNumbers as List<Double>))
    } catch (e: NullPointerException) {
        println("Wrong list")
    } catch (e: ClassCastException) {
        println("Wrong list")
    }
}

fun arithmeticMean(numbers: List<Double>): Double {
    if (numbers.size != 0) {
        var sum: Double = 0.0
        for (number in numbers) {
            sum += number
        }
        return sum / numbers.size
    } else
        return 0.0
}