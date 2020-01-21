package com.examle.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
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
    runBlocking {
        println("Launch channel")
        launch {
            for (i in 1..5) {
                channel.send(i)
            }
            channel.close()
        }
        for (i in channel) {
            println("Channel: $i")
        }
    }

    // Same with producer/consumer pattern
    runBlocking {
        val producer = produce {
            for (i in 1..5) {
                send(i)
            }
        }
        producer.consumeEach {
            println("Producer/Consumer Channel: $it")
        }
    }

    // Fan-Out - Distribute workload
    runBlocking {
        val producer = producer(this)
        repeat(5) {
            processor(this@runBlocking, it, producer)
        }
        delay(1000)
        // cancelling a producer coroutine closes its channel
        producer.cancel()
    }
}

fun producer(coroutineScope: CoroutineScope) = coroutineScope.produce {
    var counter = 0
    while (true) {
        send(counter++)
        delay(100)
    }
}

fun <T> processor(coroutineScope: CoroutineScope, id: Int, receiveChannel: ReceiveChannel<T>) =
    coroutineScope.launch {
        // for loop pattern is perfectly safe to use from multiple coroutines
        for (i in receiveChannel) {
            println("Received via channel: $i in thread: ${Thread.currentThread().name} in: $id")
        }
    }
