package com.examle

import com.examle.model.Person
import com.examle.model.test

fun main(args: Array<String>) {

    val person = Person("Tamas", 28)
    println(person.toString())
    println(test(person))
}

