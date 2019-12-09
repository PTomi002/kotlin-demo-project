package com.examle.high_order_functions

// inline keyword
// inline functions in the Kotlin standard library are always small!!
// Generally, the parameter can be inlined if it’s called directly or passed as an argument
// to another inline function.
inline fun tryOutLambdaFunct(nums: Int, names: String, operation: (num: Int, name: String) -> Double): Double {
    // called directly.
    return operation(nums, names)
    // This way an anonym class implementing it would be compiled.
    // Execution overhead on each call to instantiate the anonym class instead of just executing the code.
    // return OperationExecutor(nums, names, operation)
}

fun String.addOneCharacter(block: (String) -> String): String {
    // The actual object of the string class.
    return block(this)
}

fun main() {
    // Declare a lambda
    // Return in a lambda returns from the outer function
    val sameFunct: (num: Int, name: String) -> Double = { num, name ->
        println("$name and $num")
        Double.MAX_VALUE
    }
    // local-return from the lambda!
    val funct: (num: Int, name: String) -> Double = localReturn@{ num, name ->
        println("$name and $num")
        return@localReturn Double.MAX_VALUE
    }
    println(funct(10, "Tamas"))

    // Call in a function
    tryOutLambdaFunct(10, "Tamas") { name, num ->
        println("$name and $num")
        Double.MAX_VALUE
    }

    tryOutLambdaFunct(10, "Tamas", funct)
    // local return lambda with String receiver
    val str = "Testing"
    println(str.addOneCharacter { it + "C" })
}