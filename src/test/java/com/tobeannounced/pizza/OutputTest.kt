package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test

class OutputTest {

    @Test
    fun shouldOutputResult() {
        val solution = emptySet<Set<Pair<Int, Int>>>()
        assertEquals("0", output(solution))
    }

    @Test
    fun shouldOutputResultForSingleSlice() {
        val solution = setOf(setOf(
                0 to 0,
                0 to 1))
        assertEquals("1\n" +
                "0 0 0 1", output(solution))
    }
}