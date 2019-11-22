package com.examle.numbers

interface Expression {
    // abstract method
    // as interface always open and public
    fun kind()

    // default impl
    fun kindOf(): Unit = println("Expression")
}