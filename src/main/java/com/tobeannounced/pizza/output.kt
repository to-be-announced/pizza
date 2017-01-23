package com.tobeannounced.pizza

fun output(solution: Set<Set<Pair<Int, Int>>>) = buildString {
    append(solution.count())
    solution.forEach { slice ->
        val rMin = slice.map { it.first }.min()
        val rMax = slice.map { it.first }.max()
        val cMin = slice.map { it.second }.min()
        val cMax = slice.map { it.second }.max()
        append("\n$rMin $cMin $rMax $cMax")
    }
}