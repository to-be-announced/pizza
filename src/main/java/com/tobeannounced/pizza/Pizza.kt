package com.tobeannounced.pizza

data class Pizza(val pieces: List<Piece>, val width: Int, val height: Int, val min: Int, val max: Int)

data class Piece(val r: Int, val c: Int, val kind: PieceKind, val assigned: Boolean)

enum class PieceKind {
    MUSHROOM,
    TOMATO
}
