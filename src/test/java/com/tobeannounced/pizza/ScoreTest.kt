package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreTest {

    @Test
    fun shouldCalculateScoreWhenNoPieceIsAssigned() {
        val pieces = listOf(
                Piece(0, 0, PieceKind.MUSHROOM, false),
                Piece(0, 1, PieceKind.TOMATO, false)
        )
        val score = calculateScore(Pizza(pieces, 2, 1, 1, 1))

        assertEquals(0, score)
    }

    @Test
    fun shouldCalculateScoreWhenOnePieceIsAssigned() {
        val pieces = listOf(
                Piece(0, 0, PieceKind.MUSHROOM, true),
                Piece(0, 1, PieceKind.TOMATO, false)
        )
        val score = calculateScore(Pizza(pieces, 2, 1, 1, 1))

        assertEquals(1, score)
    }
}