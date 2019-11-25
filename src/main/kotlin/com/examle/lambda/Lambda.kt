package com.examle.lambda

import com.examle.model.Person
import java.util.concurrent.Callable

fun topLevelMethod() = println("Im top-level")

// @FunctionalInterface
// SAM interface = single abstract method
@FunctionalInterface
interface Status<T, R> {
    fun status(input: T): R
}

fun status(input: Int, sts: Status<Int, String>) {
    println(sts.status(input))
}

fun main(args: Array<String>) {

    // lambda expr
    val sum = { x: Int, y: Int -> x + y }
    println(sum(3, 4))
    val people = listOf(Person("Alice", 44), Person("Bob", 31))
    println(people.maxBy { person -> person.age })

    // method reference
    println(people.maxBy(Person::age))
    val topLevelMethodRef = ::topLevelMethod
    topLevelMethodRef()

    // If the last param is lambda then it can be extracted to {...} brackets
    // Modifying local non-final variables called CAPTURE by lambda
    println(people.joinToString("-") { it.name })

    // can change the auto generated name of the lambda input param
    println(people.joinToString("-") { person -> person.name })

    val strings = listOf("abc", "def")
    println(strings.flatMap {
        it.toList()
    })

    // Sequence API = lazy operations as Java Streams
    println(listOf(1, 2, 3, 4, 5).asSequence()
        .map { num -> num * 2 }
        .filter { num -> num > 6 }
        .toList())

    // anonym class as interface
    status(
        15,
        object : Status<Int, String> {
            override fun status(input: Int): String = "Given number is: $input"
        }
    )

    // SAM conversion to Java @FunctionalInterface
    val callable: Callable<String> = Callable { "Test String" }

    // with and apply builder style/ Lambdas with receiver type!
    println(StringBuilder("Test!").apply {
        for (i in 1..10)
            append(i.toString())
        append("End Test!")
    }.toString())
}
