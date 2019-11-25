package com.examle.delegates


interface Status<T> {

    fun kind() {
        println("Status type")
    }

    fun status(number: T): String
}

class AStatusImpl : Status<Int> {

    // object = class + 1 instance of it
    // access private members of the class
    companion object Factory {
        fun createStatus(): Status<Int> = AStatusImpl()
    }

    override fun status(number: Int) = "AStatusImpl type"
}

// Matches the interface
// Delegates by interface match with a backing object
class DelegatedStatus(backing: Status<Int>) : Status<Int> by backing {
    override fun kind() {
        println("DelegatedStatus")
    }
}

fun main(args: Array<String>) {
    val delegateStatus: Status<Int> = DelegatedStatus(AStatusImpl())
    println(delegateStatus.status(10))
    delegateStatus.kind()

    val createStatus = AStatusImpl.Factory.createStatus()
    println(createStatus)

    // anonym object example
    // on class definition "object" keyword makes it singleton automatically
    val anonymStatus = object : Status<String> {
        override fun status(number: String): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    anonymStatus.status("test")
}

