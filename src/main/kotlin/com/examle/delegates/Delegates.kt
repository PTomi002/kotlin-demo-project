package com.examle.delegates


interface Status<T> {

    fun kind() {
        println("Status type")
    }

    fun status(number: T): String
}

class AStatusImpl : Status<Int> {
    override fun status(number: Int) = "AStatusImpl type"
}

// Matches the interface
// Delegates by interface match with a backing object
class DelegatedStatus(backing: AStatusImpl) : Status<Int> by backing {
    override fun kind() {
        println("DelegatedStatus")
    }
}

fun main(args: Array<String>) {
    val delegateStatus: Status<Int> = DelegatedStatus(AStatusImpl())
    println(delegateStatus.status(10))
    delegateStatus.kind()
}

