fun main(args: Array<String>) {
    var set1: Set<Int> = setOf(1, 3, 7, 8, 5)
    var set2: Set<Int> = setOf(3, 6, 8, 9)
    printSet(intersect(set1, set2))
    println()
    printSet(union(set1, set2))
}

fun intersect(set1: Set<Int>, set2: Set<Int>): Set<Int> {
    var intersect: MutableSet<Int> = mutableSetOf()
    for (s1 in set1) {
        for (s2 in set2) {
            if (s2 == s1 && !(s2 in intersect)) {
                intersect.add(s2)
            }
        }
    }
    return intersect
}

fun union(set1: Set<Int>, set2: Set<Int>): Set<Int> {
    var union: MutableSet<Int> = mutableSetOf()
    for (s1 in set1) {
        if (!(s1 in union)) {
            union.add(s1)
        }
    }
    for (s2 in set2) {
        if (!(s2 in union)) {
            union.add(s2)
        }
    }
    return union
}

fun printSet(set: Set<Int>) {
    for (s in set) {
        print(s)
        print(" ")
    }
}
