package com.examle.abc

// abstract classes and methods open by default
abstract class A {

    abstract fun test(number: Int): State

    open fun tests(vararg numbers: Int) {
        // i in numbers ==> numbers.contains(i)
        for (i in numbers) {
            println(test(i).state())
        }
    }
}