/**
 * Разбор строк.
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку.
 * Обратите внимание: некорректная с точки зрения календаря дата
 * (например, 30 февраля 2009) считается неверными  входными данными.
 */

fun main(args: Array<String>) {
    dateFormatFromNumbersToString()
}

fun dateFormatFromNumbersToString() {
    var dateIntList: List<Int> = enterDate()
    if (correctFormat(dateIntList)) {
        val monthNames: List<String> = listOf("января", "февраля", "марта", "апреля",
            "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря")
        print(dateIntList[0])
        print(" ")
        print(monthNames[dateIntList[1] - 1])
        print(" ")
        print(dateIntList[2])
    }
}

fun correctFormat(dateIntList: List<Int>): Boolean {
    if (dateIntList.size != 3) {
        return false
    }
    for (dateNum in dateIntList) {
        if (dateNum < 1) {
            return false
        }
    }
    if (dateIntList[1] > 12) {
        return false
    }
    if (dateIntList[1] % 2 == 1) {
        if (dateIntList[1] < 8) {
            if (dateIntList[0] > 31) {
                return false
            }
        } else if (dateIntList[1] > 8) {
            if (dateIntList[0] > 30) {
                return false
            }
        }
    } else {
        if (dateIntList[1] == 2) {
            if (leapYear(dateIntList[2])) {
                if (dateIntList[0] > 29) {
                    return false
                }
            } else if (dateIntList[0] > 28) {
                return false
            }
        } else {
            if (dateIntList[1] < 7) {
                if (dateIntList[0] > 30) {
                    return false
                }
            } else {
                if (dateIntList[0] > 31) {
                    return false
                }
            }
        }
    }
    return true
}

fun leapYear(year: Int): Boolean {
    if (year % 100 == 0 && year % 400 == 0 ) {
        return true // 366
    } else if (year % 4 == 0 && year % 100 > 0) {
        return true // 366
    } else {
        return false // 365
    }
}

fun enterDate(): List<Int> {
    println("Enter the date in the format dd.mm.yy")
    var dateString: String? = readLine()
    var delimeter: String = "."
    var dateSubString: List<String> = dateString?.split(delimeter) ?: listOf("str")
    var dateInt: MutableList<Int> = mutableListOf()
    try {
        for (str in dateSubString) {
            dateInt.add(str.toInt())
        }
    } catch(e: Exception) {
//        println("Wrong")
    }
    return dateInt
}
