package com.tobeannounced.pizza

import java.io.File

fun parsePizza(file: File): PizzaProblem {
    return file.reader().useLines { linesSequence ->
        val lines = linesSequence.toList()
        val pizzaParams = lines.first().split(" ")
        val pieces = lines.drop(1).mapIndexed { r, line ->
            line.mapIndexed { c, char -> Piece(r, c, char.toKind(), false) }
        }.flatMap { it }
        PizzaProblem(
                Pizza(pieces, pizzaParams[0].toInt(), pizzaParams[1].toInt()),
                ProblemParams(pizzaParams[2].toInt(), pizzaParams[3].toInt())
        )
    }
}

private fun Char.toKind(): PieceKind {
    return when (this) {
        'T' -> PieceKind.TOMATO
        'M' -> PieceKind.MUSHROOM
        else -> throw RuntimeException()
    }
}
