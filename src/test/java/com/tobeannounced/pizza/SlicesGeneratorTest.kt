package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
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
    fun shouldReturnNearbyNeighbours() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(2, 0, PieceKind.TOMATO, assigned = false)

        assertEquals(setOf(p2), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p1, deepth = 1))
        assertEquals(setOf(p1, p3), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p2, deepth = 1))
        assertEquals(setOf(p2), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p3, deepth = 1))
    }

    @Test
    fun shouldReturnFarNeighbours() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(2, 0, PieceKind.TOMATO, assigned = false)

        assertEquals(setOf(p2,p3), findNeighbours(Pizza(setOf(p1, p2, p3), width = 1, height = 3), p1, deepth = 2))
    }

    @Test
    fun shouldReturnTwoSlices_oneSmallAndOneBig_forVerticalSlice() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(1, 0, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(2, 0, PieceKind.TOMATO, assigned = false)
        assertEquals(setOf(setOf(p1, p2), setOf(p1, p2, p3)), possibleSlices(Pizza(setOf(p1, p2, p3), 1, 3), piece = p1, minNumberOfEachKind = 1, maxSliceSize = 3))
    }

    @Test
    fun shouldReturnTwoSlices_oneSmallAndOneBig_forHorizontalSlice() {
        val p1 = Piece(0, 0, PieceKind.MUSHROOM, assigned = false)
        val p2 = Piece(0, 1, PieceKind.TOMATO, assigned = false)
        val p3 = Piece(0, 2, PieceKind.TOMATO, assigned = false)
        assertEquals(setOf(setOf(p1, p2), setOf(p1, p2, p3)), possibleSlices(Pizza(setOf(p1, p2, p3), 1, 3), piece = p1, minNumberOfEachKind = 1, maxSliceSize = 3))
    }

    private fun emptyResults() = emptySet<Set<Piece>>()
}