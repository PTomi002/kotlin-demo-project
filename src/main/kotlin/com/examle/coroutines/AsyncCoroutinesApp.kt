package com.examle.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val strOne = "Testing"
        val one = async(start = CoroutineStart.LAZY) {
            println("Comp. done on: ${this}!")
            strOne.add(" Lazy Starting Async")
            // within the same coroutine context if one child dies with ex the others are cancelled recursively!
            throw IllegalArgumentException("Testing structured cancellation on other async function!")
        }
        val two = async {
            try {
                println("Comp. done on: ${this}!")
                delay(Long.MAX_VALUE)
                //return@async strOne.add(" Now Starting Async")
                strOne.add(" Now Starting Async")
            } finally {
                println("This one was cancelled!")
            }
        }
        // In this mode it only starts the coroutine when its result is required by await, or if its Job's start function is invoked.
        one.start()
        println("Result is: ${one.await()} and ${two.await()}")
    }
}

suspend fun String.add(other: String): String {
    delay(1000)
    return this + other
}