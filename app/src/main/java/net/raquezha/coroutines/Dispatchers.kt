package net.raquezha.coroutines


import kotlinx.coroutines.*

/**
 * Created by raquezha on 8/4/23.
 *
 * Precise thread management with Coroutine Dispatchers
 * https://www.youtube.com/watch?v=hxuyKLmMquE&ab_channel=Kt.Academy
 */

suspend fun main() = coroutineScope {
    println("""
-------------------------------------------------
Welcome to Advance Kotlin | Coroutine Dispatcher
-------------------------------------------------
1. Dispatcher Main
2. Dispatcher IO
-------------------------------------------------
""")

    println("Please enter the number you want to run: ")

    when(readln()) {
        "1" -> {
            println("running default dispatcher...")
            defaultDispatcherTest()
        }
        else -> {
            println("Invalid input. exiting...")
        }
    }
}

/**
 * Starts a 1000 coroutine and sleeps for one second and prints its Thread name.
 *
 * Uses Dispatchers.Default - use for CPU operations. It is backed by a shared pool of threads on JVM.
 * It is limited by CPU's core. Depends on your machine cpu core when you run this.
 * This will use all the thread available limited by cpu core then sleeps for 1 second, then
 * repeats again
 */
suspend fun defaultDispatcherTest() =  coroutineScope {
    repeat(1000) {
        launch(Dispatchers.Default) {
            // we can suppress this warning for this demo
            @Suppress("BlockingMethodInNonBlockingContext")
            Thread.sleep(1000)
            println("Running on thread ($it): ${Thread.currentThread().name}")
        }
    }
}
