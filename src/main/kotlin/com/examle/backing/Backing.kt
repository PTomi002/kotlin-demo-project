package com.examle.backing

class A {
    var name: String = ""
        private set(value) {
            println("Changing from: $field -> $value".trimIndent())
            field = value
        }

    constructor(name: String) {
        this.name = name
    }
}

fun main(args: Array<String>) {
    val a: A = A("Tamas")
    // a.name = "Sanyi" Not possible due to private setter
}

