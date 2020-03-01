/**
 * Ветвления.
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */

fun main(args: Array<String>) {
    triangleTypeBySideLengths()
}

fun triangleTypeBySideLengths() {
    var a: Double = enterSideLength("first")
    var b: Double = enterSideLength("second")
    var c: Double = enterSideLength("third")
    println("a = $a, b = $b, c = $c")
    var h: Double = 0.0
    var k: Double = 0.0
    var l: Double = 0.0
    if ((a + b > c) && (a + c > b) && (b + c > a)) {
        if (a > b && a > c) {
            h = a
            k = b
            l = c
        } else if (b > a && b > c) {
            h = b
            k = a
            l = c
        } else {
            h = c
            k = a
            l = b
        }
        println()
        println("Answer:")
        if (h*h < k*k + l*l) println("0")
        else if (h*h == k*k + l*l) println("1")
        else println("2")
    }
    else {
        println()
        println("Answer:")
        println("-1")
    }
    println("--------------------------------------")
    println("0 - acute acute triangle (angles < 90)")
    println("1 - rectangular triangle (angle = 90)")
    println("2 - obtuse triangle (angle > 90)")
    println("-1 - such a triangle does not exist")
}

// if a non-integer is entered, 0 is returned as the value of the variable
fun enterSideLength(s: String): Double {
    println("Enter the lengths of the " + s + " side")
    var lenString = readLine()
    try {
        var lenDouble: Double = lenString?.toDouble() ?: 0.0
        if (lenDouble < 0.0) return 0.0
        else return lenDouble
    }
    catch(e: NumberFormatException) {
        println("NumberFormatException")
        return 0.0
    }
}



