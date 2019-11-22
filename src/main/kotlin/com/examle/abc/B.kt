package com.examle.abc

class B(val num: Int) : A() {
    override fun test(number: Int): State =
        when {
            number % 2 == 0 -> BState("Even")
            else -> BState("Odd")
        }

    // Inner class by default
    // contains reference to the outer class
    inner class BState(val state: String) : State {
        // Overrided property
        override val str: Char
            get() = state.first()

        override fun state(): String {
            println(this@B.num)
            return state
        }
    }

    // Nested Class by default
    // public static class BNestedState (...)
    // Overrided property
    class BNestedState(val state: String, override val str: Char) : State {
        override fun state(): String = state
    }
}