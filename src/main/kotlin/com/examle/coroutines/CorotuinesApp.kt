package com.examle.coroutines

import kotlinx.coroutines.*

inline fun <T, I, O> T.applyTesting(input: I, block: T.(I) -> O): O {
    return block(input)
}

fun main() {
    val test: Double = 12.applyTesting("Testing!") { inp ->
        println("This is: $this and input: $inp")
        Double.MIN_VALUE
    }

    // top-level coroutine, non-blocking
    // like daemon threads
    val job = GlobalScope.launch {
        delay(2000)
        println("Testing global scope launch")
    }
    // wait from the main thread
    Thread.sleep(2300)

    // Same achieved this way
    runBlocking {
        val resultJob: Job = launch {
            delay(1000)
            println("Inner launch block")
        }
        // suspends, releasing the underlying thread for other usages, suspend function
        val result: Unit = coroutineScope {
            launch {
                delay(1000)
                println("Double nested block")
            }
            delay(500)
            println("Nested scope block")
        }
        testCoroutinesFunction()
    }
}

suspend fun testCoroutinesFunction() {
    delay(1000)
    println("Suspending function block")
}
