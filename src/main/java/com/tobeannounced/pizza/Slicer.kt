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
    else pizza.pieces
            .filter { !it.assigned }
            .filter { Math.pow(it.r - piece.r,2) <= 1 + Math.pow(it.c - piece.c,2) < 2 }
            .filter { it != piece }
            .flatMap { setOf(it) + findNeighbours(pizza.copy(pieces = pizza.pieces.minus(piece)), it, depth - 1) }
            .toSet()
}
