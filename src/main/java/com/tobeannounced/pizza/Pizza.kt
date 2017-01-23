package com.tobeannounced.pizza

data class PizzaProblem(val pizza: Pizza, val params: ProblemParams)

data class ProblemParams(val min: Int, val max: Int)

data class Pizza(val pieces: List<Piece>, val width: Int, val height: Int) {

    fun score() = pieces.count { it.assigned }
}

data class Piece(val r: Int, val c: Int, val kind: PieceKind, val assigned: Boolean)

enum class PieceKind {
    MUSHROOM,
    TOMATO
}
