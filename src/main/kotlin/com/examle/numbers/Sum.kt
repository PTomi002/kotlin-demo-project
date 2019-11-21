package com.examle.numbers

class Sum(
    internal val left: Expression
    , internal val right: Expression
) : Expression {
    override fun kind() {
        println("Sum kind!")
    }
}