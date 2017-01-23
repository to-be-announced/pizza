package com.tobeannounced.pizza

fun possibleSlices(pizza: Pizza, piece: Piece, minNumberOfEachKind: Int, maxSliceSize: Int): Set<Set<Piece>> {
    if (maxSliceSize <= 1) {
        return emptySet()
    } else {
        return (1..maxSliceSize).map { pieceFamily(it, piece, pizza) }.toSet()
    }
}

private fun pieceFamily(maxSliceSize: Int, piece: Piece, pizza: Pizza): Set<Piece> {
    val findNeighbours = findNeighbours(pizza, piece, maxSliceSize)
    return findNeighbours + piece
}

fun findNeighbours(pizza: Pizza, piece: Piece, deepth: Int): Set<Piece> {
    return if (deepth == 0) emptySet()
    else pizza.pieces.filter { Math.abs(it.r - piece.r) <= 1 && it.c == 0 }
            .filter { it != piece }
            .flatMap { setOf(it) + findNeighbours(pizza.copy(pieces = pizza.pieces.minus(piece)), it, deepth - 1) }
            .toSet()
}