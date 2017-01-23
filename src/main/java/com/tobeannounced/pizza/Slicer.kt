package com.tobeannounced.pizza

fun possibleSlices(pizza: Pizza, piece: Piece, minNumberOfEachKind: Int, maxSliceSize: Int): Set<Set<Piece>> {
    if (maxSliceSize <= 1) {
        return emptySet()
    } else {
        return (1..maxSliceSize).map {
            (findNeighbours(pizza, piece, depth = it) + piece)
        }.toSet()
    }
}

fun findNeighbours(pizza: Pizza, piece: Piece, depth: Int): Set<Piece> {
    return if (depth == 0) emptySet()
    else pizza.pieces.filter { Math.abs(it.r - piece.r) <= 1 && Math.abs(it.c - piece.c) <= 1 }
            .filter { it != piece }
            .flatMap { setOf(it) + findNeighbours(pizza.copy(pieces = pizza.pieces.minus(piece)), it, depth - 1) }
            .toSet()
}