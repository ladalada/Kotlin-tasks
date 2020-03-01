/**
 * Простые функции.
 * Пользователь задает длину отрезка в саженях, аршинах и вершках
 * (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах
 * (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
*/

fun main(args: Array<String>){
    lengthFromFathomsArshinsTopsToMeters()
}

fun lengthFromFathomsArshinsTopsToMeters() {
    var numFathoms: Double = enterNumber("fathoms")
    var numArshins: Double = enterNumber("arshins")
    var numTops: Double = enterNumber("tops")
    var numMetres: Double = (numFathoms * 48 + numArshins * 16 + numTops) * 4.445 / 100
    println("$numFathoms fathoms $numArshins arshins $numTops tops = $numMetres metres")
}

// if a non-integer is entered, 0 is returned as the value of the variable
fun enterNumber(units: String): Double {
    println("Enter the number of " + units)
    var numString = readLine()
    try {
        var numDouble: Double = numString?.toDouble() ?: 0.0
        if (numDouble < 0.0) return 0.0
        else return numDouble
    }
    catch(e: NumberFormatException) {
        println("NumberFormatException")
        return 0.0
    }
}

