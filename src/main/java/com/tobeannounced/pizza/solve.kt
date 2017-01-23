package com.tobeannounced.pizza

fun solve(problem: PizzaProblem): Set<Set<Piece>> {
    return solve(problem.pizza, curryPizza(problem.params.min, problem.params.max))
}

private fun solve(pizza: Pizza, possibleSlices: (Pizza, Piece) -> Set<Set<Piece>>): Set<Set<Piece>> {
    return possibleSlices(pizza, pizza.pieces.first { !it.assigned })
}

private fun curryPizza(minNumberOfEachKind: Int, maxSliceSize: Int): (Pizza, Piece) -> Set<Set<Piece>> {
    return { pizza: Pizza, piece: Piece ->
        possibleSlices(pizza, piece, minNumberOfEachKind, maxSliceSize)
    }
}