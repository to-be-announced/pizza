package com.tobeannounced.pizza

fun possibleSlices(pizza: Pizza, piece: Piece, minNumberOfEachKind: Int, maxSliceSize: Int): Set<Set<Piece>> {
    val pieces = pizza.pieces.filter { !it.assigned }
    return possibleSlices2(pieces, setOf(setOf(piece)))
            .filter { it.isValid(minNumberOfEachKind, maxSliceSize) }.toSet()
}

private fun Set<Piece>.isValid(minNumberOfEachKind: Int, maxSliceSize: Int): Boolean {
    return count { it.kind == PieceKind.MUSHROOM } >= minNumberOfEachKind &&
            count { it.kind == PieceKind.TOMATO } >= minNumberOfEachKind &&
            size <= maxSliceSize
}

fun possibleSlices2(pieces: List<Piece>, slices: Set<Set<Piece>>): Set<Set<Piece>> {
    return slices.flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }
            .flatMap { fourWayExtend(pieces, it) }.toSet()
}

fun fourWayExtend(pieces: List<Piece>, slice: Set<Piece>): Set<Set<Piece>> {
    return setOf(
            expand(pieces, slice, rightNeighbour),
            expand(pieces, slice, leftNeighbour),
            expand(pieces, slice, topNeighbour),
            expand(pieces, slice, bottomNeighbour),
            slice
    )
}

//6 7 1 5
//TM MMTTT
//MM MMTMM
//TT MTTMT
//TM MTMMM
//TT TTTTM
//TT TTTTM

private fun expand(pieces: List<Piece>, slice: Set<Piece>, neighbour: (Piece, Piece) -> Boolean): Set<Piece> {
    val newPieces = slice.map { piece -> pieces.find { neighbour(it, piece) } }
    return if (newPieces.contains(null)) {
        emptySet()
    } else {
        slice + newPieces.filterNotNull()
    }
}

private val rightNeighbour: (Piece, Piece) -> Boolean = { a, b -> a.r == b.r + 1 && a.c == b.c }
private val leftNeighbour: (Piece, Piece) -> Boolean = { a, b -> a.r == b.r - 1 && a.c == b.c }
private val topNeighbour: (Piece, Piece) -> Boolean = { a, b -> a.r == b.r && a.c - 1 == b.c }
private val bottomNeighbour: (Piece, Piece) -> Boolean = { a, b -> a.r == b.r && a.c + 1 == b.c }

@Deprecated("meh", replaceWith = ReplaceWith("possibleSlices"))
fun findNeighbours(pizza: Pizza, piece: Piece, depth: Int): Set<Piece> {
    return if (depth == 0) emptySet()
    else pizza.pieces
            .filter { !it.assigned }
            .filter { Math.abs(it.r - piece.r) <= 1 && Math.abs(it.c - piece.c) <= 1 }
            .filter { it != piece }
            .flatMap { setOf(it) + findNeighbours(pizza.copy(pieces = pizza.pieces.minus(piece)), it, depth - 1) }
            .toSet()
}