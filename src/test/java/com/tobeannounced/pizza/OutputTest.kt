package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test

class OutputTest {

    @Test
    fun shouldOutputResult() {
        val solution = emptySet<Set<Piece>>()
        assertEquals("0", output(solution))
    }
}