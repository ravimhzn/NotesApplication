package com.ravimhzn.mynotes.dummy

class Person(val name: String, val age: Int = 0) {
    override fun toString(): String {
        return name + " is " + age + " years Old"
    }
}

fun main(args: Array<String>) {
    var person = Person(name = "vignesh")
    var personNew = Person("vignesh", 23)
    println(person.toString())
    println(personNew.toString())
}