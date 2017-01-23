package com.tobeannounced.pizza

class Pizza(val pieces: List<Piece>, val width: Int, val height: Int, val min: Int, val max: Int)

class Piece(val r: Int, val c: Int, val kind: PieceKind, val assigned: Boolean)

enum class PieceKind {
    MUSHROOM,
    TOMATO
}
