package com.examle.dsl


fun String.testReceiverTypes(number: Int, block: String.(Int) -> Double): Double = block(number)
fun testLambdaTypes(number: Int, str: String, block: (Int, String) -> Double): Double = block(number, str)

fun main() {
    // Receiver types
    val doubleResult = "2".testReceiverTypes(14) { inp ->
        inp.div(this.toInt()).toDouble()
    }
    println(doubleResult)

    // Lambda types -> Receiver is not used!!
    val doubleSecondResult = testLambdaTypes(14, "2") { inp, str ->
        inp.div(str.toInt()).toDouble()
    }
    println(doubleSecondResult)

    // DSL
    val table = table {
        tr {
            td("Testing 1st") {}
            td("Testing 2nd") { }
        }
        tr {
        }
    }
    println(table.toString())
}

// DSL examples
open class Tag {
    private val children: MutableList<Tag> = mutableListOf()

    override fun toString(): String = children.joinToString(":")

    private fun store(tag: Tag) {
        children.add(tag)
    }

    protected fun <T : Tag> init(tag: T, block: T.() -> Unit) {
        tag.block()
        store(tag)
    }
}

fun table(block: Table.() -> Unit) = Table().apply(block)

class Table : Tag() {
    fun tr(block: Tr.() -> Unit) {
        init(Tr(), block)
    }
}

class Tr : Tag() {
    fun td(value: String, block: Td.() -> Unit) {
        init(Td(value), block)
    }
}

data class Td(var value: String) : Tag()


