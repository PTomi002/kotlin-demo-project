package com.examle

import com.examle.model.Person
import com.examle.model.test
import com.examle.model.whenControlFlow
import com.examle.numbers.Expression
import com.examle.numbers.Num
import com.examle.numbers.Sum
import java.util.*

fun main(args: Array<String>) {

    // Person tests
    val person = Person("Tamas", 28)
    val personOther = Person("Erzsi", 54)
    val personThree = Person("TSanyi", 22)

    println(person.toString())
    println(test(person))
    whenControlFlow(person)

    // Comparator tests
    val setOfPersons = TreeSet<Person>()
    setOfPersons.add(person)
    setOfPersons.add(personOther)
    setOfPersons.add(personThree)
    println(setOfPersons)
    val outOfRangePeron = Person("Tlaci", 23)
    println(
        when (outOfRangePeron) {
            in setOfPersons -> "In of person range!"
            else -> "Out range person!"
        }
    )

    // control flow tests
    // named arguments
    println(evaulateExpressions(expression = Sum(left = Sum(Num(1), Num(2)), right = Num(4))))

    // range/progression tests
    fizzBuzz()
    rangeCheckExample('a')
    rangeCheckExample('Z')

    // try-catch-finally
    val res = causeException()
    println(res)

    //call extension function
    println(person.test())
}

// last value will be the result
fun causeException() =
    try {
        "13fsvwer".toInt()
    } catch (ex: IllegalArgumentException) {
        ex
    }

fun rangeCheckExample(character: Char) {
    val setOfCharacters = TreeSet<Char>(setOf('A', 'B', 'Z'))
    for ((index, chr) in setOfCharacters.withIndex()) {
        println("Index: $index with value: $chr")
    }
    when (character) {
        in setOfCharacters -> println("In range with: $setOfCharacters")
        !in setOfCharacters -> println("Not in range with: $setOfCharacters")
        else -> println("Unknown range!")
    }
}

fun evaulateExpressions(expression: Expression): Int =
    when (expression) {
        is Num -> {
            // smart cast after class type check
            println("Num type: ${expression.kind()}")
            expression.number
        }
        is Sum -> {
            println("Sum type: ${expression.kind()} + ${expression.kind()}")
            evaulateExpressions(expression.left) + evaulateExpressions(expression.right)
        }
        else -> throw IllegalArgumentException("Unknown expression type!")
    }

fun fizzBuzz() {
    for (i in 1 until 20 step 2) {
        when {
            i % 3 == 0 -> println("fizz")
            i % 5 == 0 -> println("buzz")
            i % 15 == 0 -> println("fizzbuzz")
            else -> println(i)
        }
    }
}


