/**
 * Перевести заданное целое число n >= 0
 * в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки,
 * цифры более 9 представлять латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c.
 * Использовать функции стандартной библиотеки, напрямую и полностью
 * решающие данную задачу (например, n.toString(base) и подобные),
 * запрещается.
 */

fun main(args: Array<String>) {
    numberConversionToAnotherNumberSystem()
}

fun numberConversionToAnotherNumberSystem() {
    var enteredNumber: Int = enterIntegerNumber()
    var newBase: Int = enterNewBase()
    var newNumber: MutableList<Int> = mutableListOf()
    if (enteredNumber < 0) { // correct: >= 0
        println("Wrong number")
    } else if (newBase < 2 || newBase > 36) { // correct: 2..36
        println("Wrong base")
    } else {
        print("$enteredNumber base 10 = ")
        while (enteredNumber >= newBase) {
            newNumber.add(enteredNumber % newBase)
            enteredNumber = enteredNumber / newBase
        }
        newNumber.add(enteredNumber)
        for (i in (newNumber.size - 1) downTo 0 step 1) {
            if (newNumber[i] > 9) {
                print(' ' + newNumber[i] + 55) // int to char
            } else print(newNumber[i])
        }
        print(" base $newBase")
    }
}

fun enterNewBase(): Int {
    println("Enter a new base")
    var newBase: Int
    try {
        newBase = readLine()?.toInt() ?: -1
        if (newBase < 2 || newBase > 36) {
            newBase = -1
        }
    }
    catch(e: NumberFormatException) {
        newBase = -1
    }
    println("newBase = $newBase")
    return newBase
}

fun enterIntegerNumber(): Int {
    println("Enter a positive integer number")
    var enteredNumber: Int
    try {
        enteredNumber = readLine()?.toInt() ?: -1
        if (enteredNumber < 0) {
            enteredNumber = -1
        }
    }
    catch(e: NumberFormatException) {
        enteredNumber = -1
    }
    println("enteredNumber = $enteredNumber")
    return enteredNumber
}
