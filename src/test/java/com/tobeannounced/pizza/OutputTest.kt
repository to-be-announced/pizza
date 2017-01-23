package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test

class OutputTest {

    @Test
    fun shouldOutputResult() {
        val solution = emptySet<Set<Piece>>()
        assertEquals("0", output(solution))
    }

    @Test
    fun shouldOutputResultForSingleSlice() {
        val solution = setOf(setOf(
                Piece(0, 0, PieceKind.MUSHROOM, true),
                Piece(0, 1, PieceKind.TOMATO, true)))
        assertEquals("1\n" +
                "0 0 0 1", output(solution))
    }
}