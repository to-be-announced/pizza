package com.tobeannounced.pizza

class Pizza(val pieces: List<Piece>)

class Piece(val r: Int, val c: Int, val kind: PieceKind, val assigned: Boolean)

enum class PieceKind {
    MUSHROOM,
    TOMATO
}
