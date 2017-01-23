package com.tobeannounced.pizza

fun output(solution: Set<Set<Piece>>) = buildString {
    append(solution.count())
    solution.forEach { slice ->
        val rMin = slice.map { it.r }.min()
        val rMax = slice.map { it.r }.max()
        val cMin = slice.map { it.c }.min()
        val cMax = slice.map { it.c }.max()
        append("\n$rMin $cMin $rMax $cMax")
    }
}