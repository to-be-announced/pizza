package com.tobeannounced.pizza

import java.io.File

fun Set<Set<Piece>>.toSlices() = map { it.map { it.cell }.toSet() }.toSet()

fun printSolutionFor(file: File) {
    println(outputFrom(solve(parsePizza(file)).toSlices()))
}

fun outputFrom(solution: Set<Set<Pair<Int, Int>>>) = buildString {
    append(solution.count())
    solution.forEach { slice ->
        val rMin = slice.map { it.first }.min()
        val rMax = slice.map { it.first }.max()
        val cMin = slice.map { it.second }.min()
        val cMax = slice.map { it.second }.max()
        append("\n$rMin $cMin $rMax $cMax")
    }
}