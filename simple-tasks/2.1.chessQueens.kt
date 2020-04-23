/**
 * Ветвления.
 * На шахматной доске стоят два ферзя
 * (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу.
 * Вернуть true, если угрожают.
 */

import java.lang.Math.abs

fun main(args: Array<String>) {
    chessQueens()
}

fun chessQueens() {
    var position1: Array<Int> = enterPosition("first")
    var position2: Array<Int> = enterPosition("second")
    println("position1[0] = " + position1[0])
    println("position1[1] = " + position1[1])
    println("position2[0] = " + position2[0])
    println("position2[1] = " + position2[1])
    var check1: Boolean = checkAboutRightPosition("first", position1)
    var check2: Boolean = checkAboutRightPosition("second", position2)
    var check3: Boolean = checkAboutDifferentPositions(position1, position2)
//    printDiagonalPositions(position1)
    if (check1 && check2 && check3 == true) {
        println(queensThreatenEachOther(position1, position2))
    }
}

fun queensThreatenEachOther(position1: Array<Int>, position2: Array<Int>): Boolean {
    var x1: Int = position1[0]
    var y1: Int = position1[1]
    var x2: Int = position2[0]
    var y2: Int = position2[1]
    if (x1 == x2 || y1 == y2) {
        return true
    }
    else if (abs(x1 - x2) == abs(y1 - y2)) {
        return true
    }
    else return false
}

fun checkAboutDifferentPositions(position1: Array<Int>, position2: Array<Int>): Boolean {
   if  (position1[0] == position2[0] && position1[1] == position2[1]) {
       println("Positions of the figures coincide")
       return false
   } else return true
}

fun checkAboutRightPosition(figureNum: String, positionCoordinates: Array<Int>): Boolean {
    if (positionCoordinates[0] == 0 || positionCoordinates[1] == 0) {
        println("Wrong position of the $figureNum figure")
        return false
    } else return true
}

fun enterPosition(figureNum: String): Array<Int> {
    println("Position of the $figureNum figure")
    println("Enter character")
    var xInt: Int = intCharacterToChessInt(stringToInt())
    println("Enter number")
    var yInt: Int = intNumberToChessInt(stringToInt())
    var positionCoordinates: Array<Int> = arrayOf(xInt, yInt)
    return positionCoordinates
}

fun stringToInt(): Int {
    var enteredString = readLine()
    var enteredStringToInt: Int = 0
    if (enteredString != null) {
        if (enteredString.length == 1) {
            enteredStringToInt = enteredString[0].toInt()
        }
    }
    return enteredStringToInt
}

fun intCharacterToChessInt(intCharacter: Int): Int {
    var characterChessInt: Int = intCharacter - 96
    return chessIntInRange(characterChessInt)
}

fun intNumberToChessInt(intNumber: Int): Int {
    var numberChessInt: Int = intNumber - 48
    return chessIntInRange(numberChessInt)
}

fun chessIntInRange(chessInt: Int): Int {
    if (chessInt < 1 || chessInt > 8) {
        return 0
    }
    else {
        return chessInt
    }
}

//fun printDiagonalPositions(position1: Array<Int>) {
//    var x1: Int = position1[0]
//    var y1: Int = position1[1]
//    while(x1 in (1..7) && y1 in (1..7)) {
//        x1 += 1
//        y1 += 1
//        println("$x1, $y1")
//    }
//    x1 = position1[0]
//    y1 = position1[1]
//    while(x1 in (2..8) && y1 in (2..8)) {
//        x1 -= 1
//        y1 -= 1
//        println("$x1, $y1")
//    }
//    x1 = position1[0]
//    y1 = position1[1]
//    while(x1 in (2..8) && y1 in (1..7)) {
//        x1 -= 1
//        y1 += 1
//        println("$x1, $y1")
//    }
//    x1 = position1[0]
//    y1 = position1[1]
//    while(x1 in (1..7) && y1 in (2..8)) {
//        x1 += 1
//        y1 -= 1
//        println("$x1, $y1")
//    }
//}
