package com.examle.numbers

open class Num(internal val number: Int) : Expression {
    // after primary constructor init
    // validation
    init {
        if (number < 0) throw IllegalArgumentException("Invalid number: $number!")
    }

    // Default visibility: public
    // By default everything is final
    // Must mark with open keyword
    internal open fun baseFun() = number.toString()

    override fun kind() {
        println("Numeric kind!")
    }

    override fun kindOf() {
        super.kindOf()
        println("Num")
    }
}

fun Num.validate() = number > 0
