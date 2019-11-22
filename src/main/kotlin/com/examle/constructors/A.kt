package com.examle.constructors

// Primary constructor
open class A internal constructor(num: Int) {
    // Does not generate getter/setter with property
    val num: Int

    init {
        this.num = num
    }
}

// val generates property with getter/setter
class B(val isNum: Boolean, num: Int) : A(num)

class C : A {
    val isNum: Boolean

    // Secondary constructor cannot have val or var
    // Can have code as initialize block
    internal constructor(isNum: Boolean) : this(isNum, 0)

    protected constructor(isNum: Boolean, num: Int) : super(num) {
        this.isNum = isNum
    }
}

fun main(args: Array<String>) {
    val c = C(false)
    println(c)
}
