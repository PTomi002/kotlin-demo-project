package com.examle.operator_overload

import kotlin.properties.Delegates

// Operator overload
// operator overload keyword, predefined operators can be overrided
data class Point(val a: Int, val b: Int) {
    operator fun plus(other: Point) = Point(a + other.a, b + other.b)
}

operator fun Point.minus(other: Point) = Point(a - other.a, b - other.b)

operator fun Point.get(index: Int): Int =
    when (index) {
        0 -> a
        1 -> b
        else -> throw IndexOutOfBoundsException("Point index is only two-dimensional!")
    }

// Delegated property
class Person {

    var name: String by Delegates.observable("<not set>") { prop, old, new ->
        println("${prop.name} changed, old value: $old, new value: $new")
    }
}

fun main() {
    val pointOne = Point(3, 4)
    val pointTwo = Point(5, -10)
    // Simple operator overload
    println(pointOne - pointTwo)

    // Index operator overload
    println(pointTwo[1])

    // Destructuring declaration
    val (x, y) = pointOne
    println("Destructured: $x, $y")

    // Delegated property
    val person = Person()
    println("Person: ${person.name}")
    person.name = "Tamas"

    // invoke convention
    val greeter = Greeter()
    greeter("Test", 13)
}

// invoke convention
class Greeter {
    operator fun invoke(values: String, number: Int) {
        println("Invoked as a function with: $values and $number")
    }
}
