package com.examle.numbers

class NumChild(number: Int) : Num(number) {
    // Default visibility: public
    // By default everything is final
    // This function overrides an open function and is open as well.
    // Must mark with final to close inheritance possibility
    final override fun baseFun() = number.toString()
}