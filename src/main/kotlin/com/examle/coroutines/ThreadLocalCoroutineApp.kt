package com.examle.coroutines

import kotlinx.coroutines.*

fun main() {
    val threadLocal = ThreadLocal.withInitial { "Initial String" }

    runBlocking {
        launch(Dispatchers.Default + threadLocal.asContextElement(value = "First ctx string")) {
            // Good example for property extension
            println(isActive)
            println("Current thread is: ${Thread.currentThread().name} and thr local value is: ${threadLocal.get()}")
            // Suspend the execution on the current Thread
            yield()
            println("Current thread is: ${Thread.currentThread().name} and thr local value is: ${threadLocal.get()}")
        }
    }
}