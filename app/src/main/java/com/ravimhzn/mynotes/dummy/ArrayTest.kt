package com.ravimhzn.mynotes.dummy

fun main(args: Array<String>) {
    //filtering()
    proFiltering()
}

fun filtering() {
    val numStrings = listOf("One", "Two", "Three", "Four")
    val longerThan3 = numStrings.filter { it.length > 3 }
    println(longerThan3)

    /**
     * For the map
     */

    val numberMap = mapOf("Key1" to 1, "Key2" to 2, "Key3" to 11)
    println(numberMap.keys)
    println(numberMap.values)
    println(numberMap)

    println(numberMap.filter { (k, v) -> v > 10 })
}

fun proFiltering() {
    var a = listOf(5, 6, 7)

    var m = a.map { it * 5 }
    println(m)
    var ab = m.filter { it > 32 }
    println(ab)
//        .map { it * 5 }
//        .filter { it > 25 }
}
