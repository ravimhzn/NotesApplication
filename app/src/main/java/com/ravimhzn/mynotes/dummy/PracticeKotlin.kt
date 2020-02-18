package com.ravimhzn.mynotes.dummy


fun main(args: Array<String>) {
    inlineFunction({ println("Hello, funciton1") }, { println("Hello, function2") })
}

inline fun inlineFunction(myFunction1: () -> Unit, myFunction2: () -> Unit) {
    println("**Calling inline Function")
    myFunction1()
    myFunction2()
    println("It's Awesome")

    println("**************")
    var aClass = a()
    aClass addNumbers 5
   // println()
}

class a {

    //val a: Int by Lazy {10}

    var ab = 10
    infix fun addNumbers(a: Int) {
        ab += a
        println("Added:: $ab")
    }
}

data class Employee(var name: String)


/*
 /**
     * Elvis Operator
     */
//    var str: String? = "Ravi Maharjan"
//    var newStr: String = "Default Value"
//    println(newStr)
//    //str = null
//    newStr = str?: "Default Value"
//    println(newStr)
//
//    var str: String? = "Ravi Maharjan"
//    println(str)
//    str = null
//    str.let { println(str) }
//    println()


//    val emp1 = Employee("Ravi")
//    val emp2 = Employee("Ravi")
//
//    println(emp1 == emp2)
//    println(emp1 === emp2)
 */