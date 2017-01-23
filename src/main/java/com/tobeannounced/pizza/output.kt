package com.tobeannounced.pizza

fun output(solution: Set<Set<Piece>>) = buildString {
    append(solution.count())
}