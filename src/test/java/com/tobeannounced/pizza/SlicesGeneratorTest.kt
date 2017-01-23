package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class SlicesGeneratorTest {

    @Test
    fun shouldReturnEmptyResultsIfMaxSliceSizeIsLowerThanOne() {
        val element = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        assertEquals(emptyResults(), possibleSlices(Pizza(setOf(element), 1, 1), element, 1, 0))
    }

    @Test
    fun shouldReturnZeroSlicesIfPizzaSizeIsOne() {
        val element = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        assertEquals(emptyResults(), possibleSlices(Pizza(setOf(element), 1, 1), element, 1, 1))
    }

    @Test
    fun shouldReturnOneSliceIfPizzaContainsBothIngredients() {
        val mushroom = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val tomato = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        assertEquals(setOf(setOf(mushroom, tomato)), possibleSlices(Pizza(setOf(tomato, mushroom), 1, 1), mushroom, 1, 2))
    }

    @Test
    fun shouldReturnNeighbours() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(2, 0, PieceKind.TOMATO, assigned = false)

        assertEquals(setOf(p2), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p1))
        assertEquals(setOf(p1, p3), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p2))
        assertEquals(setOf(p2), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p3))
    }

    private fun findNeighbours(pizza: Pizza, piece: Piece): Set<Piece> {
        return pizza.pieces.filter { Math.abs(it.r - piece.r) <= 1 && it.c == 0 }
                .filter { it != piece }
                .toSet()
    }

    @Test
    @Ignore
    fun shouldReturnTwoSlices_oneSmallAndOneBig() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(2, 0, PieceKind.TOMATO, assigned = false)
        assertEquals(setOf(setOf(p1, p2), setOf(p1, p2, p3)), possibleSlices(Pizza(setOf(p1, p2, p3), 1, 3), p1, 1, 3))
    }


    private fun emptyResults() = emptySet<Set<Piece>>()
}