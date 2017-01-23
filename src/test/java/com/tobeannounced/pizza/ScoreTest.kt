package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreTest {

    @Test
    fun shouldCalculateScoreWhenNoPieceIsAssigned() {
        val score = Pizza(listOf(
                Piece(0, 0, PieceKind.MUSHROOM, false),
                Piece(0, 1, PieceKind.TOMATO, false)
        ), 2, 1).score()

        assertEquals(0, score)
    }

    @Test
    fun shouldCalculateScoreWhenOnePieceIsAssigned() {
        val score = Pizza(listOf(
                Piece(0, 0, PieceKind.MUSHROOM, true),
                Piece(0, 1, PieceKind.TOMATO, false)
        ), 2, 1).score()

        assertEquals(1, score)
    }

    @Test
    fun shouldCalculateScoreWhenAllPiecesAreAssigned() {
        val score = Pizza(listOf(
                Piece(0, 0, PieceKind.MUSHROOM, true),
                Piece(0, 1, PieceKind.TOMATO, true)
        ), 2, 1).score()

        assertEquals(2, score)
    }
}