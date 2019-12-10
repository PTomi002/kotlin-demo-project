package com.examle.generics

// Generic function declaration: upper bound for 'T' template
// Java: T extends Comparable
fun <T : Comparable<T>> maximum(one: T, two: T): T = if (one > two) one else two

// Read only constraint: type projection: we say that source isn’t a MutableList, but a projected (restricted) one
// Java: MutableList<? extends Number>
// This is use-site variance
fun producer(listOfNums: MutableList<out Number>) {
    for (num in listOfNums) println(num)
}

// List defines it: interface List<out E> : Collection<E>
// List uses: declaration-site variance in the class def.
fun producerWithList(listOfNums: List<Number>) {
    for (num in listOfNums) println(num)
}

// Consumer only constraint
// Java: MutableList<? super Integer>
fun consumer(listOfNums: MutableList<in Int>) {
    for (num in listOfNums) println(num)
}

fun main() {
    // Generic function usage
    val one = 13
    val two = -85
    println(maximum(one, two))

    // Covariance
    val listOfInts = mutableListOf(1, 2, 3)
    producer(listOfInts)
    producerWithList(listOfInts)

    // Contravariance
    val listOfLongs = mutableListOf(1L, 2L, 3L)
    val listOfNumbers = mutableListOf(1, 3.45, 12L)
    val listIfDoubles = mutableListOf(1.2, 4.2)
    consumer(listOfInts)
    consumer(listOfNumbers)

    // Star projection: * = only one unknown type can be
    // Any? = anything can be which subtypes Any
    val listOfAType: List<*> = listOf("a", "b")
    val listOfAny: List<Any?> = listOf("a", 1.43)
}