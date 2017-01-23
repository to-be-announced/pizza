package com.tobeannounced.pizza

fun possibleSlices(pizza: Pizza, piece: Piece, minNumberOfEachKind: Int, maxSliceSize: Int): Set<Set<Piece>> {
    if (maxSliceSize <= 1) {
        return emptySet()
    } else {
        return setOf(pizza.pieces.toSet())
    }
}