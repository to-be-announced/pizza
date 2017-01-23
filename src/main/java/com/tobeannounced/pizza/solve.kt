package com.tobeannounced.pizza

fun solve(problem: PizzaProblem): Set<Set<Piece>> {
    try {
        return solve(problem.pizza, curryPizza(problem.params.min, problem.params.max)).best()
    } catch (solution: Solution) {
        return solution.best
    }
}

private fun List<Set<Set<Piece>>>.best(): Set<Set<Piece>> {
    return this.maxBy { it.sumBy { it.size } }!!
}

private fun solve(pizza: Pizza,
                  possibleSlices: (Pizza, Piece) -> Set<Set<Piece>>,
                  currentSolutions: List<Set<Set<Piece>>> = listOf(emptySet())): List<Set<Set<Piece>>> {
    val best = currentSolutions.best()
    if (best.sumBy { it.size } == 42) {
        throw Solution(best)
    } else {
        if (pizza.isSolved()) {
            return currentSolutions
        } else {
            return solveUnsolved(pizza, possibleSlices, currentSolutions)
        }
    }
}

class Solution(val best: Set<Set<Piece>>) : Throwable()

private fun solveUnsolved(pizza: Pizza, possibleSlices: (Pizza, Piece) -> Set<Set<Piece>>, currentSolutions: List<Set<Set<Piece>>>): List<Set<Set<Piece>>> {
    val piece = pizza.pieces.first { !it.assigned }
    val possibleSolutions = possibleSlices(pizza, piece).flatMap { it: Set<Piece> ->
        solve(pizza.removeAll(it), possibleSlices, addToSolution(currentSolutions, it))
    }
    val alternativeSolution = solve(pizza.remove(piece), possibleSlices, currentSolutions)
    return possibleSolutions + alternativeSolution
}

private fun addToSolution(currentSolutions: List<Set<Set<Piece>>>, newPiece: Set<Piece>): List<Set<Set<Piece>>> {
    return currentSolutions.map { it.plusElement(newPiece) }
}

private fun Pizza.removeAll(pieces: Set<Piece>): Pizza {
    return pieces.fold(this, Pizza::remove)
}

private fun Pizza.remove(piece: Piece): Pizza {
    return copy(pieces - piece + piece.copy(assigned = true))
}

private fun curryPizza(minNumberOfEachKind: Int, maxSliceSize: Int): (Pizza, Piece) -> Set<Set<Piece>> {
    return { pizza: Pizza, piece: Piece ->
        possibleSlices(pizza, piece, minNumberOfEachKind, maxSliceSize)
    }
}

private fun Pizza.isSolved(): Boolean {
    println(pieces.count { it.assigned })
    return pieces.all { it.assigned }
}
