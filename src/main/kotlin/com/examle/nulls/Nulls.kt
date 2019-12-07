package com.examle.nulls

// ? means the variable can be null or type
data class Employee(val name: String, val employees: List<Employee>?)

// If not null, then call uppercase or return default value.
// Elvis operator: ?:
fun uppercaseStr(str: String?) = str?.toUpperCase() ?: "Was null!"

fun letOperatorTest(): String? = null

// Nothing = the function never terminates normally
fun nothingTest(): Nothing = throw IllegalArgumentException()

fun main(args: Array<String>) {
    val emplOne = Employee("Tamas", null)
    val emplTwo = Employee("Laci", listOf(emplOne))

    val boss = Employee("Sanyi", null)

    // ? means safe-call operator = null check + method call
    println(boss.employees?.first())

    // Safe-cast operator: cast or null
    println(12 as? Double ?: false)

    // let keyword = calls lambda only if variable not null or does nothing
    val letTest: String? = letOperatorTest()
    println(letTest?.let { it.toUpperCase() })

    // Extension functions can be called safely on nulls.
    val nullStr: String? = null
    println(nullStr.isNullOrBlank())

    // Convert to non-null or throw exception if null
    val str: String? = null
    println(str!!)
}
