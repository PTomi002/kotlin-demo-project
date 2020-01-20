package com.examle.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    // Do not run until subscription is available
    val intFlow = flow {
        for (i in 1..10) {
            emit(i)
        }
    }
    runBlocking {
        // Collect = Project Reactor's Subscription
        intFlow.collect {
            println(it)
        }
    }

    // Reactive Channel between coroutines
    val channel = Channel<Int>()

}