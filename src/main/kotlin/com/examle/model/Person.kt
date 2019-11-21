package com.examle.model

import com.examle.enums.Sex

// top-level property
// public static final String = ...
const val UNIX_LINE_SEPARATOR = "\n"

// data = automatic fun generations beside getter/setter
data class Person(val name: String, val age: Int = -1) : Comparable<Person> {
    override fun compareTo(other: Person): Int =
        when {
            age > other.age -> 1
            age < other.age -> -1
            else -> 0
        }

    val isMale: Sex
        get() {
            return if (name.startsWith("T")) Sex.MALE else Sex.FEMALE
        }
}

// top-level functions
// (module visibility) static Person test(...) {...}
internal fun test(person: Person) = person.isMale

fun whenControlFlow(person: Person) {
    when (person.isMale) {
        Sex.FEMALE -> println("A branch called")
        Sex.MALE -> println("B branch called")
    }
}

// extension function
// received=Person receiver=Kotlin
// compiles to: static test(Person person) {return person.name.last()}
fun Person.test(): Char = this.name.last()