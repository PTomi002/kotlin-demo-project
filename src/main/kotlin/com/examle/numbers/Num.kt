package com.examle.numbers

class Num(internal val number: Int) : Expression {
    override fun kind() {
        println("Numeric kind!")
    }
}