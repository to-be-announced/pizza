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
        val slice = setOf(0 to 0, 0 to 1)
        val solution = setOf(slice)
        assertEquals("1\n" +
                "0 0 0 1", output(solution))
    }

    @Test
    fun shouldOutputResultForMultipleSlices() {
        val slice1 = setOf(0 to 0, 0 to 1, 1 to 0, 1 to 1, 2 to 0, 2 to 1)
        val slice2 = setOf(0 to 2, 1 to 2, 2 to 2)
        val slice3 = setOf(0 to 3, 0 to 4, 1 to 3, 1 to 4, 2 to 3, 2 to 4)
        val solution = setOf(slice1, slice2, slice3)
        assertEquals("3\n" +
                "0 0 2 1\n" +
                "0 2 2 2\n" +
                "0 3 2 4", output(solution))
    }
}