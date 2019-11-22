package com.examle

import com.examle.numbers.Num

fun main(args: Array<String>) {
    // triple-quoted string => dont have to escape characters
    val dirNormalStr = "/Users/yole/kotlin-book/chapter.adoc"
    val regexpNormalStr = "(.+)/(.+)\\.(.+)" // escaping happens
    val regexp = """(.+)/(.+)\.(.+)""".toRegex()
    println(regexp.matchEntire(dirNormalStr)?.destructured)

    // Validation
    val num = Num(1)
    num.kindOf()
}