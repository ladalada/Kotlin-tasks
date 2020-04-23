/**
 * Циклы.
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 * Использовать операции со строками в этой задаче запрещается.
 */

fun main(args: Array<String>) {
    sequenceOfSquaresOfIntegers()
}

fun sequenceOfSquaresOfIntegers() {
    var enteredDigitNumber: Int = enterDigitNumber()

    var sequenceDigitCounter: Int = 0
    var square: Int = 0
    var squareDigitCounter: Int = 0
    var dozens: Int = 0

    var iterator: Int = 0

    if (enteredDigitNumber > 0) {

        // create a sequence of squares
        while (sequenceDigitCounter < enteredDigitNumber) {
            iterator += 1
            square = iterator * iterator

            // count the digits in the created square
            squareDigitCounter = 1
            dozens = 10
            while (square / dozens != 0) {
                dozens = dozens * 10
                squareDigitCounter += 1
            }

            sequenceDigitCounter += squareDigitCounter // in the entered position or further (bigger)
        }

        sequenceDigitCounter -= squareDigitCounter // go back one square
        dozens /= 10

        // go from the beginning of the square forward one digit
        var desiredNumber: Int = 0
        while (sequenceDigitCounter != enteredDigitNumber) {
            // we take each digit from the square and its number in the sequence
            desiredNumber = square / dozens % 10
            dozens = dozens / 10
            sequenceDigitCounter += 1
        }
        println("square = $square")
        println("desiredNumber:")
        println(desiredNumber)
    }
    else println("There is no such position in the sequence.")
}

fun enterDigitNumber(): Int {
    println("Enter the digit position number in the sequence")
    var enteredDigitNumber: Int
    try {
        enteredDigitNumber = readLine()?.toInt() ?: 0
    }
    catch(e: NumberFormatException) {
        enteredDigitNumber = 0
    }
    println("enteredDigitNumber = $enteredDigitNumber")
    return enteredDigitNumber
}
