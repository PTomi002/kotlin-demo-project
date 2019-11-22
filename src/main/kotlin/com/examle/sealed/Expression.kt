package com.examle.sealed

// Defines all the possible subclasses, but no more can be added
// Abstract by default
// Cant be an interface
sealed class Expression {

    abstract fun doSomething()

    // Can be nested/inner
    // Java: static class
    class Sum(val left: Expression, val right: Expression) : Expression() {
        override fun doSomething() {
            println("Sum is: $left + $right")
        }
    }
}

// But must be in the same file
class Num(val num: Int) : Expression() {
    override fun doSomething() {
        println("Num is: $num")
    }
}

fun controlFlow(expression: Expression) {
    when (expression) {
        is Num -> expression.doSomething()
        is Expression.Sum -> expression.doSomething()
        // No need for else branch, cant cause bugs with new subclass
    }
}

fun main(args: Array<String>) {
    val num = Num(13)
    controlFlow(num)
}