package com.examle

import com.examle.model.Person
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HelloTest {

    // For DI FWs mostly like Spring.
    private lateinit var person: Person

    @Before
    fun setup() {
        person = Person("Tamas", 13)
    }

    @Test
    fun testMockitoWithKotlin() {
        // when
        var actualAge = person.age
        // then
        assertEquals(13, actualAge)
    }
}
