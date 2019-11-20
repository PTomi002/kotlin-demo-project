package com.examle.model

import com.examle.enums.Sex

class Person(val name: String, val age: Int = -1) {
    val isMale: Sex
        get() {
            return if (name.startsWith("T")) Sex.MALE else Sex.FEMALE
        }
}

fun test(person: Person) = person.isMale