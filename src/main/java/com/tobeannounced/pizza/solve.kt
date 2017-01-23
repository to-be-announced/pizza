package com.tobeannounced.pizza

fun solve(problem: PizzaProblem): Set<Set<Piece>> {
    return possibleSlices(problem.pizza,
            problem.pizza.pieces.first { !it.assigned },
            problem.params.min,
            problem.params.max)
}